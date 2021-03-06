/*
 * Daniel R Padilla
 *
 * Copyright (c) 2009, Daniel R Padilla
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package testlink.eclipse.plugin.views.tree;


import java.util.ArrayList;

/**
 * The class for the most part is generated by the eclipse plugin
 * examples and has been modified for use with the TestLink viewer.
 * 
 * The class represents a node in a tree that is not a leaf. Since
 * in the TestLinkTree nodes do not dynamically become parents or
 * leafs. Then this object always has children in the extended classes.
 * 
 *
 */
public class TreeParentNode extends TreeNode
{
	protected ArrayList children;
	public TreeParentNode(
		String name)
	{
		super(name);
		children = new ArrayList();
	}

	/**
	 * Add descendant with proper preferences.
	 * 
	 * @param child
	 */
	public void addChild(
		TreeNode child)
	{
		// Avoid invisible root/parent null preferences
		if ( getPreferences() != null ) {
			child.setPreferences(getPreferences());
		}
		children.add(child);
		child.setParent(this);
	}

	/**
	 * Dispose of the parent and all descendants
	 * 
	 * @param child
	 */
	public void removeChild(
		TreeNode child)
	{
		if ( child instanceof TreeParentNode ) {
			TreeParentNode childInParentRole = (TreeParentNode) child;
			TreeNode[] grandchildren = childInParentRole.getChildren(true);
			for ( int i = 0; i < grandchildren.length; i++ ) {
				TreeNode grandchild = grandchildren[i];
				removeChild(grandchild);
			}
		}
		children.remove(child);
		child.setParent(null);
	}

	/**
	 * Get the direct descendants for this parent.
	 * 
	 * @return
	 */
	public TreeNode[] getChildren()
	{
		return getChildren(false);
	}

	/**
	 * Get the children that have been instantiated and
	 * do not worry about instantiation or initialization
	 * of the children.
	 * 
	 * @param skipFind
	 * @return
	 */
	public TreeNode[] getChildren(
		boolean skipFind)
	{
		if ( !skipFind ) {
			if ( children.size() == 0 ) {
				findChildren();
			}
		}
		return (TreeNode[]) children.toArray(new TreeNode[children.size()]);
	}

	/**
	 * Has direct descendants
	 * 
	 * @return
	 */
	public boolean hasChildren()
	{
		return children.size() > 0;
	}
	
	/**
	 * place holder
	 */
	public void findChildren()
	{}
}


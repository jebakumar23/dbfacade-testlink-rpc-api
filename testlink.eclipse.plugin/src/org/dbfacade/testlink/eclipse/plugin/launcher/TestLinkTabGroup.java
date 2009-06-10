/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 * David Saff (saff@mit.edu) - bug 102632: [JUnit] Support for JUnit 4.
 *******************************************************************************/
package org.dbfacade.testlink.eclipse.plugin.launcher;


import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;

import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab;


public class TestLinkTabGroup extends AbstractLaunchConfigurationTabGroup
{
     
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(
		ILaunchConfigurationDialog dialog,
		String mode)
	{
		try {
			TestLinkLaunchConfigurationTab testLinkTab = new TestLinkLaunchConfigurationTab();
			JavaArgumentsTab argsTab = new JavaArgumentsTab();
			JavaClasspathTab classPathTab = new JavaClasspathTab();
			JavaJRETab jreTab = new JavaJRETab();
			SourceLookupTab srcTab = new SourceLookupTab();
			EnvironmentTab envTab = new EnvironmentTab();
			CommonTab commonTab = new CommonTab();
			ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				testLinkTab, argsTab, classPathTab, jreTab, srcTab, envTab, commonTab
			};

			setTabs(tabs);
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(
		ILaunchConfigurationWorkingCopy config)
	{
		super.setDefaults(config);
		// AssertionVMArg.setArgDefault(config);
	}
}

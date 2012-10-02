/*******************************************************************************
 * Copyright (c) 2012 Gustav Karlsson <gustav.karlsson@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gustav Karlsson <gustav.karlsson@gmail.com> - initial API and implementation
 ******************************************************************************/
package se.gustavkarlsson.gwiz;

import java.awt.Container;

import javax.swing.AbstractButton;

/**
 * An interface for creating wizards.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public interface Wizard {

	/**
	 * Gets the container where wizard pages are contained. This is used by the {@link WizardController} to (un)set
	 * wizard pages.
	 * 
	 * @return the {@link AbstractWizardPage} container
	 */
	Container getWizardPageContainer();

	/**
	 * Gets the navigation button for "cancel". This is needed so that the {@link WizardController} can enable/disable
	 * the button.
	 * 
	 * @return the "cancel" button
	 */
	AbstractButton getCancelButton();

	/**
	 * Gets the navigation button for "previous". This is used by the {@link WizardController} to navigate back in the
	 * wizard.
	 * 
	 * @return the "previous" button
	 */
	AbstractButton getPreviousButton();

	/**
	 * Gets the navigation button for "next". This is used by the {@link WizardController} to navigate forward in the
	 * wizard. Also used by {@link WizardController} to enable/disable the button.
	 * 
	 * @return the "next" button
	 */
	AbstractButton getNextButton();

	/**
	 * Gets the navigation button for "finish". This is needed so that the {@link WizardController} can enable/disable
	 * the button.
	 * 
	 * @return the "finish" button
	 */
	AbstractButton getFinishButton();

}

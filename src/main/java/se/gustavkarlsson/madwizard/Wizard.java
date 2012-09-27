package se.gustavkarlsson.madwizard;

import java.awt.Container;

import javax.swing.AbstractButton;

/**
 * An interface for creating wizards.
 * 
 * @author Gustav
 */
public interface Wizard {

	/**
	 * Gets the container where {@link WizardPage}s are contained. This is used by the {@link WizardController} to
	 * (un)set wizard pages.
	 * 
	 * @return the {@link WizardPage} container
	 */
	Container getWizardPageContainer();

	/**
	 * Gets the navigation button for "previous". This is used by the {@link WizardController} to navigate back in the
	 * wizard.
	 * 
	 * @return the "previous" button
	 */
	AbstractButton getPreviousButton();

	/**
	 * Gets the navigation button for "next". This is used by the {@link WizardController} to navigate forward in the
	 * wizard. Also needed so that the {@link WizardController} can enable/disable the button.
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

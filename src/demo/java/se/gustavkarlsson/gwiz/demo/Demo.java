package se.gustavkarlsson.gwiz.demo;

import se.gustavkarlsson.gwiz.AbstractWizardPage;
import se.gustavkarlsson.gwiz.WizardController;
import se.gustavkarlsson.gwiz.wizards.JFrameWizard;

public class Demo {

	public static void main(String[] args) {
		// Create a new wizard (this one is based on a JFrame)
		JFrameWizard wizard = new JFrameWizard("g-wiz demo");

		// Create the first page of the wizard
		AbstractWizardPage demoStartPage = new StartPage();

		// Create the controller for wizard
		WizardController wizardController = new WizardController(wizard);

		// Start the wizard and show it
		wizardController.startWizard(demoStartPage);
		wizard.setVisible(true);
	}
}

package se.gustavkarlsson.gwiz.wizards;

import se.gustavkarlsson.gwiz.AbstractWizardPage;
import se.gustavkarlsson.gwiz.WizardController;

public class JFrameWizardTest {

	public static void main(String[] args) {
		// Create a new wizard (this one is based on a JFrame)
		JFrameWizard wizard = new JFrameWizard("g-wiz demo");

		// Create the first page of the wizard
		AbstractWizardPage demoStartPage = new StartPage();

		// Create the controller for wizard
		WizardController wizardController = new WizardController(wizard);

		// Start the wizard and show it
		wizard.setVisible(true);
		wizardController.startWizard(demoStartPage);
	}
}

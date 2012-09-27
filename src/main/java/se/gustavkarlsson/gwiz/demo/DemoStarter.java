package se.gustavkarlsson.gwiz.demo;

import se.gustavkarlsson.gwiz.AbstractWizardPage;
import se.gustavkarlsson.gwiz.DefaultWizard;
import se.gustavkarlsson.gwiz.WizardController;

/**
 * Starts a demo session with a simple wizard.
 * 
 */
public class DemoStarter {
	public static void main(String[] args) {
		DefaultWizard wizard = new DefaultWizard();
		AbstractWizardPage demoStartPage = new StartPage();

		WizardController wizardController = new WizardController(wizard);
		wizardController.startWizard(demoStartPage);

		wizard.setVisible(true);
	}
}

package se.gustavkarlsson.madwizard.demo;

import se.gustavkarlsson.madwizard.DefaultWizard;
import se.gustavkarlsson.madwizard.WizardController;
import se.gustavkarlsson.madwizard.WizardPage;

/**
 * Hello world!
 * 
 */
public class DemoStarter {
	public static void main(String[] args) {
		DefaultWizard wizard = new DefaultWizard();
		WizardPage demoStartPage = new StartPage();

		WizardController wizardController = new WizardController(wizard);
		wizardController.startWizard(demoStartPage);

		wizard.setVisible(true);
	}
}

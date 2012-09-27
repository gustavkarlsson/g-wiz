package se.gustavkarlsson.gwiz.demo;

import se.gustavkarlsson.gwiz.DefaultWizard;
import se.gustavkarlsson.gwiz.WizardController;
import se.gustavkarlsson.gwiz.WizardPage;

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

package se.gustavkarlsson.madwizard;

import se.gustavkarlsson.madwizard.demo.StartPage;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		WizardPage demoStartPage = new StartPage();
		DefaultWizard demoWizard = new DefaultWizard();

		new WizardController(demoStartPage, demoWizard);

		demoWizard.pack();
		demoWizard.setVisible(true);
	}
}

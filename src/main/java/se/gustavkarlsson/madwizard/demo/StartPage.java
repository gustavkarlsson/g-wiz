package se.gustavkarlsson.madwizard.demo;

import se.gustavkarlsson.madwizard.WizardPage;

public class StartPage extends WizardPage {
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean isCompleted() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected WizardPage getNextPage() {
		// TODO Auto-generated method stub
		return new MiddlePage();
	}

}

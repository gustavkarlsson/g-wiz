package se.gustavkarlsson.madwizard.demo;

import java.awt.FlowLayout;
import java.awt.Label;

import se.gustavkarlsson.madwizard.WizardPage;

public class StartPage extends WizardPage {
	private static final long serialVersionUID = 1L;

	private final WizardPage nextPage = new MiddlePage();

	public StartPage() {
		setLayout(new FlowLayout());
		add(new Label("This is the first page of the wizard. Press Next to continue."));
	}

	@Override
	protected boolean isCompleted() {
		return true;
	}

	@Override
	protected WizardPage getNextPage() {
		return nextPage;
	}

}

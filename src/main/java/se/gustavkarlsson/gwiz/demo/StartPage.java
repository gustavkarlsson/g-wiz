package se.gustavkarlsson.gwiz.demo;

import java.awt.FlowLayout;
import java.awt.Label;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class StartPage extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;

	private final AbstractWizardPage nextPage = new MiddlePage();

	public StartPage() {
		setLayout(new FlowLayout());
		add(new Label("This is the first page of the wizard. Press Next to continue."));
	}

	@Override
	protected boolean isCompleted() {
		return true;
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return nextPage;
	}

	@Override
	protected boolean canFinish() {
		return false;
	}

}

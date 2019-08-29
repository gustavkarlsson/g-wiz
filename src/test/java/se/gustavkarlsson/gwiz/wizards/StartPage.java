package se.gustavkarlsson.gwiz.wizards;

import java.awt.FlowLayout;
import java.awt.Label;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

@SuppressWarnings("serial")
public class StartPage extends AbstractWizardPage {

	private final AbstractWizardPage nextPage = new MiddlePage();

	public StartPage() {
		setLayout(new FlowLayout());

		add(new Label("This is the first page of the wizard. Press Next to continue."));
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return nextPage;
	}

	@Override
	protected boolean isCancelAllowed() {
		return true;
	}

	@Override
	protected boolean isPreviousAllowed() {
		return true;
	}

	@Override
	protected boolean isNextAllowed() {
		return true;
	}

	@Override
	protected boolean isFinishAllowed() {
		return false;
	}

}

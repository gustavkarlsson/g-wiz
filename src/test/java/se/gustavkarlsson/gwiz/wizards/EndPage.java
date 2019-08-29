package se.gustavkarlsson.gwiz.wizards;

import java.awt.FlowLayout;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

@SuppressWarnings("serial")
public class EndPage extends AbstractWizardPage {

	private EndPanel panel = new EndPanel(this);

	public EndPage() {
		setLayout(new FlowLayout());
		add(panel);
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return null;
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
		return false;
	}

	@Override
	protected
	boolean isFinishAllowed() {		
		return panel.saidYes();
	}

}

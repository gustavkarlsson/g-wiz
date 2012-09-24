package se.gustavkarlsson.madwizard;

import javax.swing.JPanel;

public abstract class WizardPage extends JPanel {
	private static final long serialVersionUID = 1L;

	protected abstract WizardPage getNextPage();

	protected abstract boolean isCompleted();

	protected boolean canFinish() {
		return false;
	}

	final boolean isReadyForNextPage() {
		return (getNextPage() != null) && isCompleted();
	}

}

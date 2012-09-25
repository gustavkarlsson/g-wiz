package se.gustavkarlsson.madwizard;

import javax.swing.JPanel;

public abstract class WizardPage extends JPanel {
	private static final long serialVersionUID = 1L;

	private WizardController wizardController;

	void setWizardController(WizardController wizardController) {
		if (wizardController == null) {
			throw new NullPointerException("wizardController");
		}
		this.wizardController = wizardController;
	}

	protected abstract WizardPage getNextPage();

	protected abstract boolean isCompleted();

	protected boolean canFinish() {
		return false;
	}

	final boolean isReadyForNextPage() {
		return (getNextPage() != null) && isCompleted();
	}

	final boolean isReadyToFinish() {
		return isCompleted() && canFinish();
	}

	protected final void updateButtons() {
		wizardController.updateButtons();
	}

}

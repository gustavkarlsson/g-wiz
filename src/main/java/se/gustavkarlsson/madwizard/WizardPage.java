package se.gustavkarlsson.madwizard;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class WizardPage extends JPanel {
	private static final long serialVersionUID = 1L;

	private WizardController wizardController;

	public WizardPage(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public WizardPage(LayoutManager layout) {
		super(layout);
	}

	public WizardPage(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public WizardPage() {
		super();
	}

	final boolean isReadyForNextPage() {
		return (getNextPage() != null) && isCompleted();
	}

	final boolean isReadyToFinish() {
		return isCompleted() && canFinish();
	}

	void setWizardController(WizardController wizardController) {
		if (wizardController == null) {
			throw new NullPointerException("wizardController");
		}
		this.wizardController = wizardController;
	}

	protected final void updateButtons() {
		wizardController.updateButtons();
	}

	protected boolean canFinish() {
		return false;
	}

	protected abstract WizardPage getNextPage();

	protected abstract boolean isCompleted();

}

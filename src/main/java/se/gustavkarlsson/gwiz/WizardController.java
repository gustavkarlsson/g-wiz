package se.gustavkarlsson.gwiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * A controller for a {@link Wizard}. Used to control navigation, setting the correct {@link WizardPage}, and keeping
 * tack of history.
 * 
 * @author Gustav
 */
public class WizardController {

	private final Wizard wizard;
	private final Stack<WizardPage> pageHistory = new Stack<WizardPage>();
	private WizardPage currentPage = null;

	/**
	 * Creates a wizard controller for a {@link Wizard}.
	 * 
	 * @param wizard
	 *            the wizard that this controller controls
	 */
	public WizardController(Wizard wizard) {
		this.wizard = wizard;
		setupNavigationButtons();
	}

	/**
	 * Sets up navigation buttons with listeners.
	 */
	private void setupNavigationButtons() {
		wizard.getNextButton().addActionListener(new NextPageListener());
		wizard.getPreviousButton().addActionListener(new PreviousPageListener());
	}

	/**
	 * Sets a new page in the {@link Wizard} and puts the previous in the history.
	 * 
	 * @param nextPage
	 *            the page to set
	 */
	private void showNextPage(WizardPage nextPage) {
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pageHistory.push(currentPage);
		}
		currentPage = nextPage;
		updatePage();
	}

	/**
	 * Sets the previous page from the history in the {@link Wizard}.
	 */
	private void showPreviousPage() {
		wizard.getWizardPageContainer().remove(currentPage);
		currentPage = pageHistory.pop();
		updatePage();
	}

	/**
	 * Updates the {@link WizardPage} in the {@link Wizard}.
	 */
	private void updatePage() {
		currentPage.setWizardController(this);
		wizard.getWizardPageContainer().add(currentPage);
		wizard.getWizardPageContainer().validate();
		updateButtons();
	}

	/**
	 * Starts (or restarts) the {@link Wizard} with the given start {@link WizardPage}.
	 * 
	 * @param startPage
	 *            the page to start (or restart) the wizard with
	 */
	public void startWizard(WizardPage startPage) {
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pageHistory.clear();
			currentPage = null;
		}
		showNextPage(startPage);
	}

	/**
	 * Enables/disables the "next", "previous", and "finish" buttons based on the current page.
	 */
	public void updateButtons() {
		wizard.getNextButton().setEnabled(currentPage.isReadyForNextPage());
		wizard.getPreviousButton().setEnabled(!pageHistory.isEmpty());
		wizard.getFinishButton().setEnabled(currentPage.isReadyToFinish());
	}

	/**
	 * A listener that shows the next page in the {@link Wizard}.
	 * 
	 * @author Gustav
	 */
	private class NextPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showNextPage(currentPage.getNextPage());
		}
	}

	/**
	 * A listener that shows the previous page in the {@link Wizard}.
	 * 
	 * @author Gustav
	 */
	private class PreviousPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showPreviousPage();
		}
	}

}

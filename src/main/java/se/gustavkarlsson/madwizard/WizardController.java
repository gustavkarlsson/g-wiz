package se.gustavkarlsson.madwizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class WizardController {

	private final Wizard wizard;
	private final Stack<WizardPage> pages = new Stack<WizardPage>();
	private WizardPage currentPage = null;

	public WizardController(Wizard wizard) {
		if (wizard == null) {
			throw new NullPointerException("wizard");
		}
		this.wizard = wizard;
		setupNavigationButtons();
	}

	public void startWizard(WizardPage startPage) {
		if (startPage == null) {
			throw new NullPointerException("startPage");
		}
		if (currentPage != null) {
			throw new RuntimeException("Wizard already started.");
		}
		showNextPage(startPage);
	}

	private void setupNavigationButtons() {
		wizard.getNextButton().addActionListener(new NextPageListener());
		wizard.getPreviousButton().addActionListener(new PreviousPageListener());
	}

	public void updateButtons() {
		wizard.getNextButton().setEnabled(currentPage.isReadyForNextPage());
		wizard.getPreviousButton().setEnabled(!pages.isEmpty());
		wizard.getFinishButton().setEnabled(currentPage.isReadyToFinish());
	}

	private void showNextPage(WizardPage nextPage) {
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pages.push(currentPage);
		}
		currentPage = nextPage;
		updatePage();
	}

	private void showPreviousPage() {
		wizard.getWizardPageContainer().remove(currentPage);
		currentPage = pages.pop();
		updatePage();
	}

	private void updatePage() {
		currentPage.setWizardController(this);
		wizard.getWizardPageContainer().add(currentPage);
		wizard.getWizardPageContainer().validate();
		updateButtons();
	}

	private class NextPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showNextPage(currentPage.getNextPage());
		}
	}

	private class PreviousPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showPreviousPage();
		}
	}
}

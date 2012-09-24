package se.gustavkarlsson.madwizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class WizardController {

	private final Wizard wizard;
	private final Stack<WizardPage> pages = new Stack<WizardPage>();
	private WizardPage currentPage = null;

	public WizardController(WizardPage firstPage, Wizard wizard) {
		if (wizard == null) {
			throw new NullPointerException("wizard");
		}
		if (firstPage == null) {
			throw new NullPointerException("firstPage");
		}
		this.wizard = wizard;
		setupNavigationButtons();
		showNextPage(firstPage);
	}

	private void setupNavigationButtons() {
		wizard.getNextButton().addActionListener(new NextPageListener());
		wizard.getPreviousButton().addActionListener(new PreviousPageListener());
	}

	public void updateButtons() {
		wizard.getNextButton().setEnabled(currentPage.isReadyForNextPage());
		wizard.getPreviousButton().setEnabled(!pages.isEmpty());
		wizard.getFinishButton().setEnabled(currentPage.canFinish());
	}

	private void showNextPage(WizardPage nextPage) {
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pages.push(currentPage);
		}
		currentPage = nextPage;
		wizard.getWizardPageContainer().add(currentPage);
		updateButtons();
	}

	private void showPreviousPage() {
		wizard.getWizardPageContainer().remove(currentPage);
		currentPage = pages.pop();
		wizard.getWizardPageContainer().add(currentPage);
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

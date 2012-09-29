/*******************************************************************************
 * Copyright (c) 2012 Gustav Karlsson <gustav.karlsson@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Gustav Karlsson <gustav.karlsson@gmail.com> - initial API and implementation
 ******************************************************************************/
package se.gustavkarlsson.gwiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.AbstractButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A controller for a {@link Wizard}. Used to control navigation, setting the correct {@link AbstractWizardPage}, and
 * keeping tack of history.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public class WizardController {
	private static final Logger logger = LoggerFactory.getLogger(WizardController.class);

	private final Wizard wizard;
	private final Stack<AbstractWizardPage> pageHistory = new Stack<AbstractWizardPage>();
	private AbstractWizardPage currentPage = null;

	/**
	 * Creates a wizard controller for a wizard.
	 * 
	 * @param wizard
	 *            the wizard that this controller controls
	 */
	public WizardController(Wizard wizard) {
		if (wizard == null) {
			RuntimeException e = new IllegalArgumentException("wizard can't be null");
			logger.error("wizard is null.", e);
			throw e;
		}
		this.wizard = wizard;
		setupNavigationButtons();
	}

	private void setupNavigationButtons() {
		wizard.getNextButton().addActionListener(new NextPageListener());
		wizard.getPreviousButton().addActionListener(new PreviousPageListener());
	}

	private void showNextPage(AbstractWizardPage nextPage) {
		if (nextPage == null) {
			logger.error("Next page is null. Updating buttons and ignoring request.");
			updateButtons();
			return;
		}
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pageHistory.push(currentPage);
		}
		currentPage = nextPage;
		setPage();
	}

	public AbstractWizardPage getCurrentPage() {
		return currentPage;
	}

	private void showPreviousPage() {
		AbstractWizardPage previousPage;
		try {
			previousPage = pageHistory.pop();
		} catch (EmptyStackException e) {
			logger.error("Previous page is null. Updating buttons and ignoring request.");
			updateButtons();
			return;
		}
		wizard.getWizardPageContainer().remove(currentPage);
		currentPage = previousPage;
		setPage();
	}

	private void setPage() {
		currentPage.setWizardController(this);
		wizard.getWizardPageContainer().add(currentPage);
		wizard.getWizardPageContainer().validate();
		updateButtons();
	}

	/**
	 * Starts (or restarts) the wizard with the given start page.
	 * 
	 * @param startPage
	 *            the page to start (or restart) the wizard with
	 */
	public void startWizard(AbstractWizardPage startPage) {
		if (startPage == null) {
			RuntimeException e = new IllegalArgumentException("startPage can't be null");
			logger.error("startPage is null.", e);
			throw e;
		}
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
		AbstractButton nextButton = wizard.getNextButton();
		if (nextButton != null) {
			nextButton.setEnabled(currentPage.isReadyForNextPage());
		}
		AbstractButton previousButton = wizard.getPreviousButton();
		if (previousButton != null) {
			previousButton.setEnabled(!pageHistory.isEmpty());
		}
		AbstractButton finishButton = wizard.getFinishButton();
		if (finishButton != null) {
			finishButton.setEnabled(currentPage.isReadyToFinish());
		}
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

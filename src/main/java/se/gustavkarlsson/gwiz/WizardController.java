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
import java.util.Stack;

/**
 * A controller for a {@link Wizard}. Used to control navigation, setting the correct {@link AbstractWizardPage}, and
 * keeping tack of history.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public class WizardController {

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
		this.wizard = wizard;
		setupNavigationButtons();
	}

	/**
	 * Sets up navigation buttons with listeners for navigating forwards/backwards.
	 */
	private void setupNavigationButtons() {
		wizard.getNextButton().addActionListener(new NextPageListener());
		wizard.getPreviousButton().addActionListener(new PreviousPageListener());
	}

	/**
	 * Sets a new page in the wizard and puts the previous in the history.
	 * 
	 * @param nextPage
	 *            the page to set
	 */
	private void showNextPage(AbstractWizardPage nextPage) {
		if (currentPage != null) {
			wizard.getWizardPageContainer().remove(currentPage);
			pageHistory.push(currentPage);
		}
		currentPage = nextPage;
		setPage();
	}

	/**
	 * Sets the previous page from the history in the wizard.
	 */
	private void showPreviousPage() {
		wizard.getWizardPageContainer().remove(currentPage);
		currentPage = pageHistory.pop();
		setPage();
	}

	/**
	 * Updates the wizard with a new current page.
	 */
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
	 * A listener that shows the next page in the wizard.
	 * 
	 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
	 */
	private class NextPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showNextPage(currentPage.getNextPage());
		}
	}

	/**
	 * A listener that shows the previous page in the wizard.
	 * 
	 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
	 */
	private class PreviousPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showPreviousPage();
		}
	}

}

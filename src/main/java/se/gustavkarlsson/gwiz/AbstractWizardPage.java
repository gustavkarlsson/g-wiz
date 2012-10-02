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

import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * A page in a <code>Wizard</code>. Extends {@link JPanel}.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public abstract class AbstractWizardPage extends JPanel {
	private static final long serialVersionUID = 1000143453163604518L;

	private WizardController wizardController;

	/**
	 * Creates a new <code>AbstractWizardPage</code> with the specified <code>LayoutManager</code> and buffering
	 * strategy.
	 * 
	 * @param layout
	 *            the <code>LayoutManager</code> to use
	 * @param isDoubleBuffered
	 *            true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
	 * @see JPanel
	 */
	public AbstractWizardPage(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	/**
	 * Create a new double-buffered <code>AbstractWizardPage</code> with the specified <code>LayoutManager</code>
	 * 
	 * @param layout
	 *            the <code>LayoutManager</code> to use
	 * @see JPanel
	 */
	public AbstractWizardPage(LayoutManager layout) {
		super(layout);
	}

	/**
	 * Creates a new <code>AbstractWizardPage</code> with <code>FlowLayout</code> and the specified buffering strategy.
	 * 
	 * @param isDoubleBuffered
	 *            true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
	 * @see JPanel
	 */
	public AbstractWizardPage(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * Creates a new <code>AbstractWizardPage</code> with a double buffer and a <code>FlowLayout</code>.
	 * 
	 * @see JPanel
	 */
	public AbstractWizardPage() {
		super();
	}

	final boolean isReadyForNextPage() {
		return (getNextPage() != null) && isCompleted();
	}

	final boolean isReadyToFinish() {
		return isCompleted() && canFinish();
	}

	void setWizardController(WizardController wizardController) {
		this.wizardController = wizardController;
	}

	/**
	 * Updates (enables/disables) the navigation buttons of the containing <code>Wizard</code>. <br />
	 * <br />
	 * <strong>Note: Must be called every time the conditions for going to the next page or finishing changes!</strong>
	 */
	protected final void updateButtons() {
		wizardController.updateButtons();
	}

	/**
	 * Gets the page that will be displayed when the user clicks the "next" navigation button in the wizard. <br />
	 * <br />
	 * <em>Note: Actually allowing going to the next page also depends on {@link #getNextPage()}.</em>
	 * 
	 * @return the next page of the wizard
	 */
	protected abstract AbstractWizardPage getNextPage();

	/**
	 * Gets if the page is completed (i.e. ready for the next page or to finish). This should depend on the state of the
	 * page. <br />
	 * <br />
	 * <em>Note: Actually allowing going to the next page or finishing also depends on {@link #canFinish()} and
	 * {@link #getNextPage()} respectively.</em>
	 * 
	 * @return <code>true</code> if the page is completed, otherwise <code>false</code>
	 */
	protected abstract boolean isCompleted();

	/**
	 * Gets if the page allows the wizard to finish. <br />
	 * <br />
	 * <em>Note: Actually allowing finishing also depends on {@link #isCompleted()}.</em>
	 * 
	 * @return <code>true</code> if the page allows the wizard to finish, otherwise <code>false</code>
	 */
	protected abstract boolean canFinish();

}

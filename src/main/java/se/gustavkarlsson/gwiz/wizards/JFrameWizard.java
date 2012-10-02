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
package se.gustavkarlsson.gwiz.wizards;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import se.gustavkarlsson.gwiz.Wizard;

/**
 * A very simple <code>Wizard</code> implementation that suits the most basic needs. Extends {@link JFrame} and has
 * navigation buttons at the bottom.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public class JFrameWizard extends JFrame implements Wizard {
	private static final long serialVersionUID = 2818290889333414291L;

	private final JPanel wizardPageContainer = new JPanel(new GridLayout(1, 1));
	private final JButton cancelButton = new JButton("Cancel");
	private final JButton previousButton = new JButton("Previous");
	private final JButton nextButton = new JButton("Next");
	private final JButton finishButton = new JButton("Finish");

	/**
	 * Creates an <code>JFrameWizard</code> with a title and <code>GraphicsConfiguration</code>.
	 * 
	 * @param title
	 *            the title of the frame
	 * @param gc
	 *            the <code>GraphicsConfiguration</code> of the frame
	 * @see JFrame
	 */
	public JFrameWizard(String title, GraphicsConfiguration gc) {
		super(title, gc);
		setupWizard();
	}

	/**
	 * Creates an <code>JFrameWizard</code> with a title.
	 * 
	 * @param title
	 *            the title of the frame
	 * @see JFrame
	 */
	public JFrameWizard(String title) {
		super(title);
		setupWizard();
	}

	/**
	 * Creates an <code>JFrameWizard</code> with a {@link GraphicsConfiguration}.
	 * 
	 * @param gc
	 *            the <code>GraphicsConfiguration</code> of the frame
	 * @see JFrame
	 */
	public JFrameWizard(GraphicsConfiguration gc) {
		super(gc);
		setupWizard();
	}

	/**
	 * Creates an <code>JFrameWizard</code>.
	 * 
	 * @see JFrame
	 */
	public JFrameWizard() {
		super();
		setupWizard();
	}

	/**
	 * Sets up wizard upon construction.
	 */
	private void setupWizard() {
		setupComponents();
		layoutComponents();

		setMinimumSize(new Dimension(400, 350));
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Sets up the components of the wizard with listeners and mnemonics.
	 */
	private void setupComponents() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		finishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), "Wizard finished!");
				dispose();
			}
		});

		cancelButton.setMnemonic(KeyEvent.VK_C);
		previousButton.setMnemonic(KeyEvent.VK_P);
		nextButton.setMnemonic(KeyEvent.VK_N);
		finishButton.setMnemonic(KeyEvent.VK_F);
	}

	/**
	 * Lays out the components in the wizards content pane.
	 */
	private void layoutComponents() {
		GridBagLayout layout = new GridBagLayout();
		layout.rowWeights = new double[]{1.0, 0.0, 0.0};
		layout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		layout.rowHeights = new int[] {0, 0, 0};
		layout.columnWidths = new int[] {0, 0, 0, 0, 0};
		getContentPane().setLayout(layout);

		GridBagConstraints wizardPageContainerConstraint = new GridBagConstraints();
		wizardPageContainerConstraint.gridwidth = 5;
		wizardPageContainerConstraint.fill = GridBagConstraints.BOTH;
		wizardPageContainerConstraint.gridx = 0;
		wizardPageContainerConstraint.gridy = 0;
		wizardPageContainerConstraint.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(wizardPageContainer, wizardPageContainerConstraint);

		GridBagConstraints separatorConstraints = new GridBagConstraints();
		separatorConstraints.gridwidth = 5;
		separatorConstraints.fill = GridBagConstraints.HORIZONTAL;
		separatorConstraints.gridx = 0;
		separatorConstraints.gridy = 1;
		separatorConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(new JSeparator(), separatorConstraints);

		GridBagConstraints cancelButtonConstraints = new GridBagConstraints();
		cancelButtonConstraints.gridx = 1;
		cancelButtonConstraints.gridy = 2;
		cancelButtonConstraints.insets = new Insets(5, 5, 5, 0);
		getContentPane().add(cancelButton, cancelButtonConstraints);

		GridBagConstraints previousButtonConstraints = new GridBagConstraints();
		previousButtonConstraints.gridx = 2;
		previousButtonConstraints.gridy = 2;
		previousButtonConstraints.insets = new Insets(5, 5, 5, 0);
		getContentPane().add(previousButton, previousButtonConstraints);

		GridBagConstraints nextButtonConstraints = new GridBagConstraints();
		nextButtonConstraints.gridx = 3;
		nextButtonConstraints.gridy = 2;
		nextButtonConstraints.insets = new Insets(5, 5, 5, 0);
		getContentPane().add(nextButton, nextButtonConstraints);

		GridBagConstraints finishButtonConstraints = new GridBagConstraints();
		finishButtonConstraints.gridx = 4;
		finishButtonConstraints.gridy = 2;
		finishButtonConstraints.insets = new Insets(5, 5, 5, 5);
		getContentPane().add(finishButton, finishButtonConstraints);
	}

	@Override
	public JPanel getWizardPageContainer() {
		return wizardPageContainer;
	}

	@Override
	public AbstractButton getCancelButton() {
		return cancelButton;
	}

	@Override
	public JButton getPreviousButton() {
		return previousButton;
	}

	@Override
	public JButton getNextButton() {
		return nextButton;
	}

	@Override
	public JButton getFinishButton() {
		return finishButton;
	}

}

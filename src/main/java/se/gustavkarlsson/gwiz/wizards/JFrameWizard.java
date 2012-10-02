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
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;

import se.gustavkarlsson.gwiz.Wizard;

/**
 * A very simple <code>Wizard</code> implementation that suits the most basic needs. Extends {@link JFrame} and has
 * navigation buttons at the bottom.
 * 
 * @author Gustav Karlsson <gustav.karlsson@gmail.com>
 */
public class JFrameWizard extends JFrame implements Wizard {
	private static final long serialVersionUID = 2818290889333414291L;

	private final JPanel wizardPageContainer = new JPanel(new FlowLayout());
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

		setMinimumSize(new Dimension(400, 150));
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
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		int padding = 5;

		springLayout.putConstraint(SpringLayout.EAST, wizardPageContainer, -padding, SpringLayout.EAST,
				getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, wizardPageContainer, padding, SpringLayout.NORTH,
				getContentPane());
		springLayout
		.putConstraint(SpringLayout.WEST, wizardPageContainer, padding, SpringLayout.WEST, getContentPane());
		add(wizardPageContainer);

		springLayout.putConstraint(SpringLayout.SOUTH, finishButton, -padding, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, finishButton, -padding, SpringLayout.EAST, getContentPane());
		add(finishButton);

		springLayout.putConstraint(SpringLayout.NORTH, nextButton, 0, SpringLayout.NORTH, finishButton);
		springLayout.putConstraint(SpringLayout.EAST, nextButton, -padding, SpringLayout.WEST, finishButton);
		add(nextButton);

		springLayout.putConstraint(SpringLayout.SOUTH, previousButton, 0, SpringLayout.SOUTH, finishButton);
		springLayout.putConstraint(SpringLayout.EAST, previousButton, -padding, SpringLayout.WEST, nextButton);
		add(previousButton);

		springLayout.putConstraint(SpringLayout.NORTH, cancelButton, 0, SpringLayout.NORTH, finishButton);
		springLayout.putConstraint(SpringLayout.EAST, cancelButton, -padding, SpringLayout.WEST, previousButton);
		add(cancelButton);

		JSeparator separator = new JSeparator();
		springLayout.putConstraint(SpringLayout.WEST, separator, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, separator, 0, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, wizardPageContainer, -padding, SpringLayout.NORTH, separator);
		springLayout.putConstraint(SpringLayout.SOUTH, separator, -padding, SpringLayout.NORTH, finishButton);
		add(separator);
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

package se.gustavkarlsson.gwiz.demo;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

@SuppressWarnings("serial")
public class MiddlePage extends AbstractWizardPage {

	private final AbstractWizardPage nextPage = new EndPage();
	private final Checkbox continueCheckbox = new Checkbox("I want to continue!", false);

	public MiddlePage() {
		setLayout(new GridLayout(2, 1));

		add(new Label("This page does not allow you to cancel or go back, but allows finish."));
		add(continueCheckbox);

		// Add a listener for updating the wizard buttons
		continueCheckbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateWizardButtons();
			}
		});
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return nextPage;
	}

	@Override
	protected boolean isCancelAllowed() {
		return false;
	}

	@Override
	protected boolean isPreviousAllowed() {
		return false;
	}

	@Override
	protected boolean isNextAllowed() {
		// Only allow next page if continueCheckbox is checked
		return continueCheckbox.getState();
	}

	@Override
	protected boolean isFinishAllowed() {
		return true;
	}

}

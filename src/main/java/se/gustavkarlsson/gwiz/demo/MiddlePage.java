package se.gustavkarlsson.gwiz.demo;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class MiddlePage extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;

	private final AbstractWizardPage nextPage = new EndPage();
	private final Checkbox continueCheckbox = new Checkbox("I want to continue!", false);

	public MiddlePage() {
		setLayout(new FlowLayout());
		add(new Label("Check the box to continue:"));
		add(continueCheckbox);

		continueCheckbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateButtons();
			}
		});
	}

	@Override
	protected boolean isCompleted() {
		return continueCheckbox.getState();
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return nextPage;
	}

	@Override
	protected boolean canFinish() {
		return false;
	}

}

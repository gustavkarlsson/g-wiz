package se.gustavkarlsson.madwizard.demo;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import se.gustavkarlsson.madwizard.WizardPage;

public class MiddlePage extends WizardPage {
	private static final long serialVersionUID = 1L;

	private final WizardPage nextPage = new EndPage();
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
	protected WizardPage getNextPage() {
		return nextPage;
	}

}

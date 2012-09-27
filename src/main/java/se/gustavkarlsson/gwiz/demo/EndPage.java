package se.gustavkarlsson.gwiz.demo;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import se.gustavkarlsson.gwiz.AbstractWizardPage;

public class EndPage extends AbstractWizardPage {
	private static final long serialVersionUID = 1L;

	private final TextField finishTextField = new TextField("no", 5);

	public EndPage() {
		setLayout(new FlowLayout());
		add(new Label("Do you want to finish? Type in your answer:"));
		add(finishTextField);

		finishTextField.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				updateButtons();
			}
		});
	}

	@Override
	protected boolean isCompleted() {
		return finishTextField.getText().trim().equalsIgnoreCase("yes");
	}

	@Override
	protected AbstractWizardPage getNextPage() {
		return null;
	}

	@Override
	protected boolean canFinish() {
		return true;
	}

}

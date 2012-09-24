package se.gustavkarlsson.madwizard;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DefaultWizard extends JFrame implements Wizard {
	private static final long serialVersionUID = 1L;

	private final JPanel wizardPageContainer;
	private final JButton cancelButton;
	private final JButton previousButton;
	private final JButton nextButton;
	private final JButton finishButton;

	public DefaultWizard() {
		setLayout(new MigLayout("", "[right]"));

		wizardPageContainer = new JPanel();
		add(wizardPageContainer, "wrap");

		cancelButton = new JButton("Cancel");
		add(cancelButton);

		previousButton = new JButton("Previous");
		add(previousButton);

		nextButton = new JButton("Next");
		add(nextButton);

		finishButton = new JButton("Finish");
		add(finishButton);
	}

	@Override
	public JPanel getWizardPageContainer() {
		return wizardPageContainer;
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

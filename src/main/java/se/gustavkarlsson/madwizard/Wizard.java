package se.gustavkarlsson.madwizard;

import java.awt.Container;

import javax.swing.AbstractButton;

public interface Wizard {

	Container getWizardPageContainer();

	AbstractButton getPreviousButton();

	AbstractButton getNextButton();

	AbstractButton getFinishButton();
}

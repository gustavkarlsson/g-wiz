g-wiz
=====
A Java Swing Wizard API

Introduction
------------
g-wiz is an easy to use Wizard API for Java. I made it to suit my own needs, but it should come in handy for others as well.

Getting started
--------------
Getting started with g-wiz is really simple. It can be done in 4 short steps.

1.	Implement a `Wizard` (extending `AbstractSimpleWizard` is the easiest way)
2.	Implement a couple of pages by extending `AbstractWizardPage`.
3.	Initialize the wizard:<p />

		MyWizard wizard = MyWizard()
		WizardController controller = new WizardController(wizard);
4.	Start the wizard:

		AbstractWizardPage startPage = new MyStartPage();
		controller.startWizard(startPage);
		wizard.setVisible(true);

Main classes
------------
To use g-wiz, you need to familiarize yourself with 3 classes:

*	**WizardController:**
	Controls wizard behaviour such as history, navigation starting the wizard. Instanciate with a `Wizard` argument and invoke `startWizard(AbstractWizardPage)` to start with the specified page.

*	**Wizard:**
	An interface for creating wizards. A wizard theoretically can be anything, but `JFrame`, `JWindow`, `JPanel` and `JDialog` are strong candidates. The `getXyzButton()` methods should return the corresponding navigation button (or `null` if you don't need that button). `getWizardPageContainer()` should return the container which will hold the current `AbstractWizardPage`.

*	**AbstractWizardPage:**
	Represents a page in the wizard. Implement it as you would a regular `JPanel`, and make sure to override `getNextPage()`, `isCancelAllowed()`, `isPreviousAllowed()`, `isNextAllowed()`, and `isFinishAllowed()`. The method signatures should be pretty self explanatory and they are used by WizardController to update the navigation buttons.
	
	*Note: `getNextPage()` can get called multiple times by `WizardController` to check if there is a next page to show, so it's probably not a good idea to create a new "next page" every time each time it's called.*

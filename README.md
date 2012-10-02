# g-wiz
A Java Swing Wizard API


## Introduction
g-wiz is an easy to use Wizard API for Java. I made it to suit my own needs, but it should come in handy for others as well.


## Getting started
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


## Class Descriptions
To use g-wiz, you need to familiarize yourself with 3 classes:


### WizardController
Controls wizard behaviour such as maintaining history, handling navigation, starting and restarting the wizard.

Instanciate it with a `Wizard` argument and then invoke `startWizard(AbstractWizardPage)` to start the wizard with the specified page.


### Wizard
An interface for creating wizards. A wizard can theoretically be any class, but `JFrame`, `JWindow`, `JPanel` and `JDialog` are strong candidates.

`getWizardPageContainer()` is a very important method and should return the container (like a `JPanel`) which will hold the current `AbstractWizardPage`. This means that the rest of the wizard "wraps" itself around the page container, allowing the implmementer to have complete freedom over the design. The `WizardController` calls `getWizardPageContainer()` to add/remove pages to/from it, so great care should be taken when modifying it's content.

The `getXyzButton()` methods should all return the corresponding navigation button (or `null` if you don't feel like you need that button).


### AbstractWizardPage
Represents a page in the wizard. Implement it as you would a regular `JPanel`.

The `getNextPage()` method is used by the `WizardController` so it knows where pressing "Next" will take the user. It  can get called multiple times to check whether there is a "next page" to show, so it's probably not a good idea to create a new "next page" every time it's called.

`isCancelAllowed()`, `isPreviousAllowed()`, `isNextAllowed()`, and `isFinishAllowed()` are pretty self explanatory and they are used by `WizardController` to update the navigation buttons.
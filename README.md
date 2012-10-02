# g-wiz
A Java Swing Wizard API

## Introduction
g-wiz is an easy to use Wizard API for Java. I made it to suit my own needs, but it should come in handy for others as well.


## Getting started
Getting started with g-wiz is really simple. It can be done in 3 short steps.

1.	Implement a couple of pages by extending `AbstractWizardPage`.

2.	Initialize the wizard and controller (in this example we use the provided `JFrameWizard`):

		JFrameWizard wizard = JFrameWizard("My new wizard")
		WizardController controller = new WizardController(wizard);
		
3.	Start the wizard using the controller and a page:

		AbstractWizardPage startPage = new MyStartPage();
		controller.startWizard(startPage);
		wizard.setVisible(true);

You can also check out the files in src/demo for a complete example.


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

`isCancelAllowed()`, `isPreviousAllowed()`, `isNextAllowed()`, and `isFinishAllowed()` controls the navigation buttons (`WizardController` calls these to enable/disable the buttons) and should be self explanatory.


## Structure
This section explains how things like page order and history works.


### Page Order
The order of the wizard pages is not determined by the wizard itself or some pre created list; it depends entirely on the pages themself. Every page must implement `getNextPage()` which should always return the next page in the wizard (`null` is a valid return value).


### Page History
The page history consists of a stack of previously visited pages.

Everytime the user presses "Next", the current page is put on top of the stack and it's `getNextPage()` is called. The return page is then set as the new "current page". The "Previous" button however, will always take you back to the last page by "popping" the stack and setting that page as the new "current page".
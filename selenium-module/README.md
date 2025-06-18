# [Task] Selenium WebDriver
What should be done
*

WebDriver + Java + TestNG

Select a system under test (preferable: web application being tested during your project activities);

Agree with your mentor and document 3 scenarios to automate. The scenarios should be linear (no need to implement complex logic for now) and contain 8-10 simple steps;

Use WebDriver API as much as possible (browser navigation, clicks, switchTo and etc.);

Use several locator strategies i.e. different types of locators (and select the most suitable in your case);

Experiment with waits (implicit and explicit);

Extend your scenario with usage of  Page Object / Page Factory patterns.

2. If option #1 can’t be implemented by you due to any technical/project security reasons (project NDA) – use tasks from the eLearning module assigned to the learning path.

3. If option #1 and option #2 can’t be implemented by you due to any technical/project security reasons (project NDA) – use a public mail service (Mail.ru, Yandex.ru, Gmail.com and etc.) according the test flow below:

Precondition: create an account for any mail services mentioned above.

Test scenario/flow:

    Login to the mail box.
    Assert, that the login is successful.
    Create a new mail (fill addressee, subject and body fields).
    Save the mail as a draft.
    Verify, that the mail presents in ‘Drafts’ folder.
    Verify the draft content (addressee, subject and body – should be the same as in 3).
    Send the mail.
    Verify, that the mail disappeared from ‘Drafts’ folder.
    Verify, that the mail is in ‘Sent’ folder.
    Log off.

Another option – to use any EPAM service (Heroes, Grow, Time, etc.). In this case make agreement about the scenario with your mentor.
Acceptance criteria

    The scenarios are linear (no need to implement complex logic for now). 3 scenarios in total.
    Different locator strategies are used for a task.
    Usage of auto-generated locators is avoided.
    WebDriver API is widely used.
    Different methods of waits are used.
    Test scenarios are clear, stable and good structured.
    Each method in test scenario has assertions.
    Page Objects have consistent structure (decomposition of PO is right).
    Test scenarios are clear, stable and good structured.
    There is at least one level of inheritance between pages (Abstract Page exists).
    There is no code duplication at all.
    Inner implementation of PO is hidden from tests.
    Naming and Code Conventions should be followed.
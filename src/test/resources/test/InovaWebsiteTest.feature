@Web
Feature: Re-Test Cases for Inova Website without account Access
  Background:
    Given I am on the homePage

@Bug_1646
@Severity=major
Scenario: Check that the page does not display the 404 Not found error
  When Click on the Contact Us tab
  And Fill in the form
  And Click on Send message
  Then The redirection of this link should be done to the service block that has the description located on the same page.
  But The redirection is made on banner of the same page

@Bug_1647
@Severity=major
Scenario: Check if it is possible to subscribe to the newsletter
  When Enter your email address in the newsletter subscription field
  And Click on the Subscribe button
  Then A registration confirmation message should appear
  But We are redirected to a page without content with an error message at the foot of the page

@Vulnerability_1648
@Severity=major
Scenario: [Vulnérability] Non-security access to the site
  When Check URL
  Then Access is unsecured

@Bug_1651
@Severity=blocker
Scenario: Check that the command button is functional
  When Click on the Consulting tab
  And Scroll down
  And Click the Order button of the Ten Pack under Famoco Tool
  Then The action should initiate the order of the pack
  But No reaction occurs

@Bug_1655
@Severity=major
Scenario: Check that Software integration link redirection is effective
  When Click on the Consulting tab
  And Scroll to the footer
  And Click Software integration
  Then The redirection of each link should be done to each service block that has the description located on the same page.
  But The redirection is made to the banner of the same page

@Recommandation_1663
Scenario: Check that the options for accessing the social networks Facebook and Instagram are not duplicated
  When Scroll to the footer
  Then options for redirecting to social networks should appear only one time
  But Facebook and Instagram social media access options appear in duplicate

@Bug_1669
@OF-473
@Severity=minor
Scenario: Check for spelling errors
  When Scroll to the footer
  Then Spelling error at the Development level

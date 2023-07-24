Feature: Cyclos Login

  Scenario Outline: Login with valid credentials
    Given User should be on Cyclos Login Page
    When User should perform login using "<username>" and "<password>"
    Then Verfiy user is on homepage by "<verifyTxt>" and close browser

    Examples: 
      | username | password | verifyTxt |
      | demo     |     1234 | Demo user |

  Scenario Outline: Login with valid credentials using Enter Key
    Given User should be on Cyclos Login Page
    When User should perform login using "<username>" and "<password>" with Enter Key
    Then Verfiy user is on homepage by "<verifyTxt>" and close browser

    Examples: 
      | username | password | verifyTxt |
      | demo     |     1234 | Demo user |

  Scenario Outline: Login with invalid credentials
    Given User should be on Cyclos Login Page
    When User perform login using "<username>" and "<password>"
    Then Verify displaying error "<message>" and close browser

    Examples: 
      | username | password | message                                                     |
      | DEMO     |     4567 | The given name / password are incorrect. Please, try again. |

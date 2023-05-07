Feature: Login

  @Smoke
  Scenario: Validate the successful login
    Given the user is on the login page
    When he signs in with the following credentials: "standard_user", "secret_sauce"
    Then he should see the home page

  @Smoke
  Scenario: Validate the unsuccessful login with locked_out_user
    Given the user is on the login page
    When he signs in with the following credentials: "locked_out_user", "secret_sauce"
    Then he should see error message: "Sorry, this user has been locked out."

  @Smoke
  Scenario: Validate the unsuccessful login with locked_out_user failed
    Given the user is on the login page
    When he signs in with the following credentials: "locked_out_user", "secret_sauce"
    Then he should see error message: "Sorry, this user has been locked/("


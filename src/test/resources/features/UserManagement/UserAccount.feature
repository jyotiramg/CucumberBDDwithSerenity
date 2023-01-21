Feature:Mira Geoscience INTEGRATOR user account
  As a User
  I want to be able to sign in to a Geoscience INTEGRATOR user account
  So that I can able find right access
  @test
  Scenario Outline: System user signs in Geoscience INTEGRATOR application with valid credentials
    Given user navigate to the Geoscience INTEGRATOR
    When user enter the "<Email>" and "<Password>"
    And user click on Login button
    Then verify user will login successfully

    Examples:
      |Email |	Password|
      |Admin|   admin123|
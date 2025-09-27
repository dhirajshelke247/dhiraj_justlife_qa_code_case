Feature: Booking Creation and Cancellation

  Scenario Outline: Create and cancel a booking
    Given I open the Justlife checkout page
    When I login with Number "<Number>" and OTP "<OTP>"
    And I select hours
    And I select number of cleaners
    And I select material
    And I proceed to add-on page
    And I proceed to date and time page
    Then I assert no Add-ons
    When I change frequency
    And I change date and time
    And I move to step 4
    And I change payment type
    And I check for Cash Option
    And I complete Booking Process
    Then I go to Bookings page
    And I open last booking
    Then I print past booking detail

    Examples:
      | Number     | OTP  |
      | 501234567  | 4040 |

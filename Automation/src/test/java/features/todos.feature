Feature: todos testing

  Scenario: add todos
    Given I launch todomvc
      |https://todomvc.com/examples/angularjs/#/|
    And I add todos
      |Add1|
    |Add2|
    When I Verify the added todos
      |Add1|
      |Add2|

    Scenario: Complete todos
      Given I launch todomvc
        |https://todomvc.com/examples/angularjs/#/|
      And I add todos
        |Add1|
        |Add2|
      |Add3|
      |Add4|
      And I mark the completed todos
        |Add2|
      |Add4|
      When I Verify the competed todos
      |Add2|
      |Add4|


  Scenario: Delete todos
    Given I launch todomvc
      |https://todomvc.com/examples/angularjs/#/|
    And I add todos
      |Add1|
      |Add2|
      |Add3|
      |Add4|
    And I delete any of the todos
      |Add2|
      |Add4|
    When I Verify the item got removed
      |Add2|
      |Add4|

  Scenario: Filter todos
    Given I launch todomvc
      |https://todomvc.com/examples/angularjs/#/|
    And I add todos
      |Add1|
      |Add2|
      |Add3|
      |Add4|
    And I mark the completed todos
      |Add2|
      |Add4|
    When I Verify the filters are working
   |All|Add1|Add2|Add3|Add4|
    |Active|Add1|Add3|||
    |Completed|Add2|Add4|||

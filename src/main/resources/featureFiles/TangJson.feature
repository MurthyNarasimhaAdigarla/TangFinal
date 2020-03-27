Feature: To Get keys and Values in Tangerine Json file

  Scenario: To Get keys and Values in Tangerine Json file individually
    Given To Read a "Tangerine" JSON file
    Then To get all keys present in the Json file
    Then To get first individual keys in json file
    Then To get the value of all keys present in json file
    Then To get all the data from existing objects in json file
    Then To get all the data from existing arrays in json file

  Scenario: To Get  Values in Tangerine Json file for given key
    Given To Read a "Tangerine" JSON file
    And To get a value of "versionNumber" key

  Scenario: To Get keys and Values in Tangerine Json file along with Json Object
    Given To Read a "Tangerine" JSON file
    Then To retrieve the Json Object of "sourceInfo" key

  Scenario: To Get keys and Values in Tangerine Json file along with Json Array
    Given To Read a "Tangerine" JSON file
    And To retrieve the Json Array of "subOrders" key


  Scenario: To get the values of sourceInfo key in Tangerine Json file
    Given To Read a "Tangerine" JSON file
    When To retrieve the Json Array of sourceInfo key only

  Scenario: To get values for the given key and child key
    Given To Read a "Tangerine" JSON file
    When To retrieve the Json for the given key "sourceInfo" and child key "source"



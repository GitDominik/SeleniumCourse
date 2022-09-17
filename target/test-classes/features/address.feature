Feature: adding new address to clients account


  Scenario Outline: user can add new address to his account details

    Given I navigate to "https://mystore-testlab.coderslab.pl/"
    When user click sign-in button on menu
    And user enter email "doejohn@gmail.com"
    And user enter password "Johndoe100%"
    And user click sign-in on the login page
    And user click address tile while logged in
    And user click create new address tile while logged in
    And user fill address form using values: alias "<alias>", address "<address>", postalCode "<postalCode>", city "<city>", phone "<phone>",
    When click save button on address form
    Then check the address data using values: alias "<alias>", address "<address>", postalCode "<postalCode>", city "<city>", phone "<phone>",




    Examples:
      | alias  | address        | postalCode | city   | phone     |
      | JohnyD | 33 Church Road | EC10 7HN   | London | 453214568 |




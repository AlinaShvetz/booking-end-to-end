Feature: Calculating the final hidden price

  Scenario Outline: The user chooses a property and gets the final price
    Given The user opens the browser navigates to the Booking site
      When Chooses Destination: <destination> and picks dates
      And He accesses a property from the list
      And Selects  <room> Room and clicks Reserve
      Then The reservation page with the final price and hidden price Warning(if applicable) are displayed
      Examples:
                |destination | room|
                |Manchester  |  1  |
                |London      |  1  |
                |Maine       |  1  |






Feature: Login Functionality

@Login
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials with email "user@example.com" and password "validPassword123"
    And I click on the login button
    Then I should be redirected to the homepage

  Scenario: Login attempt with invalid email
    Given I am on the login page
    When I enter invalid email "invalid@example.com" and password "validPassword123"
    And I click on the login button
    Then I should see an error message "Login was unsuccessful. Please correct the errors and try again."

  Scenario: Login attempt with invalid password
    Given I am on the login page
    When I enter email "user@example.com" and invalid password "wrongPassword"
    And I click on the login button
    Then I should see an error message "Login was unsuccessful. Please correct the errors and try again."

  Scenario: Login attempt with empty email and password fields
    Given I am on the login page
    When I leave the email and password fields empty
    And I click on the login button
    Then I should see an error message "Login was unsuccessful. Please correct the errors and try again."

  Scenario: Verify error messages for invalid login attempts
    Given I am on the login page
    When I enter invalid credentials with email "wrong@example.com" and password "wrongPassword"
    And I click on the login button
    Then I should see an error message "Login was unsuccessful. Please correct the errors and try again."

  Scenario: Validate "Remember Me" functionality
    Given I am on the login page
    When I enter valid credentials with email "user@example.com" and password "validPassword123"
    And I check the "Remember Me" checkbox
    And I click on the login button
    Then I should be remembered when I return to the login page
  

@Navigation

Scenario: User selects a category and is redirected to the correct page
    Given User is on the homepage of the Demo Webshop
    When User selects the category "Books"
    Then User should be on the "Books" page
@smokeTest
  Scenario: User clicks on a navigation link and is redirected to the correct category page
    Given User is on the homepage of the Demo Webshop
    When User clicks on the "Books" link in the navigation bar
    Then User should be navigated to the "Books" category page

@Product 

  Scenario: Checking if all product images load correctly
    Given I am on a product detail page
    When I check all product images
    Then all product images should load successfully

  Scenario: Checking product specifications and description
    Given I am on a product detail page
    When I check the product specifications and description
    Then they should be displayed correctly

  Scenario: Adding product to the cart
    Given I am on a product detail page
    When I click the "Add to Cart" button
   

  Scenario: Checking product reviews and ratings
    Given I am on a product detail page
    When I check the ratings
    Then ratings should be displayed correctly

  Scenario: Adding product to the wishlist
    Given I am on a product detail page
    When I click the "Add to Wishlist" button
    Then the product should be added to my wishlist

@Checkout_Process

 
  Scenario: Entering shipping details and proceeding to checkout
    Given I am on the checkout page
    When I enter shipping details with country "India", state "Other (Non US)", and zip "411016"
    And I enter discount code "DISCOUNT1600"
    And I enter gift card code "GIFT1234"
    And I estimate shipping
    And I agree with the terms of service
    And I proceed to checkout
  


@Filters

 
    Scenario: Sort by "Position" and validate the products are displayed in the correct order
    Given I am on the product page
    When I sort the products by "Position"
    Then the products should be sorted by Position correctly

  Scenario: Sort by "Price: Low to High" and ensure products are sorted accordingly
    Given I am on the product page
    When I sort the products by "Price: Low to High"
    Then the products should be sorted by Price: Low to High correctly

  Scenario: Sort by "Price: High to Low" and validate the sorting
    Given I am on the product page
    When I sort the products by "Price: High to Low"
    Then the products should be sorted by Price: High to Low correctly

  

  
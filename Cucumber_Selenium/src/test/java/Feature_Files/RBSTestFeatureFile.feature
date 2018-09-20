Feature: Login Feature
  Verify if user is able to Order T-Shirt (and Verify in Order History)
@Test001
  Scenario: Verify if user is able to Order T-Shirt
    Given user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed
    When user navigates to T-shirts tab
    And user select size,color and Styles  
    And select the tshirt and add it to the cart    
    Then Product successfully added to your shopping cart message is displayed in a new tab
    Given user click on Proceed to Checkout and navigates to SHOPPING-CART SUMMARY page 
    Then user navigates to Summary tab 
    When proceed with the Summary tab     
    Then user navigates to 03. Address
    When proceed with the 03. Address tab 
    Then user navigates to 04. Shipping
    When proceed with the 04. Shipping tab
    Then user navigates to 05. Payment
    When user select the Pay by bank wire
    Then user gets the You have chosen to pay by bank wire. Here is a short summary of your order message is displayed
    When in ORDER SUMMARY page select the I confirm my order
    Then user gets the Your order on My Store is complete message with details  
    
 @Test002 
  Scenario: Update Personal Information (First Name) in My Account
    Given user is on homepage
    When user navigates to My Account Page
    And user navigates to My personal information  
    Then user gets the YOUR PERSONAL INFORMATION
    When user updates the FirstName
    Then user gets the Your personal information has been successfully updated. message
     
    
     
Feature: Place the order for Products

@placeOrder
Scenario Outline: Search Experience for product search in both home and offer page

Given User is on GreenCart Landing page
When User is searched with ShortName <ProductName> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <ProductName> items in checkout page
And Verify user had ability to enter promo code and place the order

Examples:
|ProductName|
|Tom        |
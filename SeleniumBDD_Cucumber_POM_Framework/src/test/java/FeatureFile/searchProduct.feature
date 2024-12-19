Feature: Search and Place the order for Products

@OfferPage
Scenario Outline: Search Experience for product search in both home and offer page

Given User is on GreenCart Landing page
When User is searched with ShortName <ProductName> and extracted actual name of product
Then User searched for <ProductName> shortname in offers page
And validate product name in offer page matches with Landing Page

Examples:
|ProductName|
|Tom        |
#|Beet       |
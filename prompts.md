
## Prompt 1
A function that checks to see if a username is valid. A username is considered valid if
- It is at least 6 characters 
- It is no more than 30 characters

<details>
<summary>Method Signature Hint</summary>

```java
interface UsernameValidator{
    boolean isValidUsername(String username);
}    
```
</details>

## Prompt 2
A function that calcuates the cost of shipping a package. The base cost of shipping a package is (weight in kilograms)*0.10 + 7.50 . If expedited shipping is selected there is an additional $15.00 fee. The cost final cost should only have 2 decimal spots

<details>
<summary>Method Signature Hint</summary>

```java
interface ShippingCalculator{
    double shippingCost(double kilos, boolean isExpedited);
}    
```
</details>
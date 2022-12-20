# Gettin Testy
You will find several coding problems to implement. You will be using TDD and good testing practicies to implement solutions. 
1. Write the method signature that satisfies the coding question
2. Write an *equivalence partition* to determine your test cases
3. Write the test cases
4. Write the implementation
5. Execute tests to see if they pass
6. Review the checklist to see if you are missing anything

## Example

#### Prompt
A group of scientists have tasked you with writing a method that converts a farenheit temperature to celcius. They would like physically impossible values to throw errors when input. 

```Java
interface TemperatureCalculator{
    double farenheitToCelcius(double temp);
}
```
#### Equivalence Partitioning with boundary values and common mistakes

|Input             |Output                 |
|------------------|-----------------------|
|     -999.99      | AbsoluteZeroException |
|     -459.67      | AbsoluteZeroException |
|     -459.66      |  -273.144444          |
|       0          |       -17.7778        |
|      100         |         37.7778       | 

```Java 
public class CalcTests {

    private static TemperatureCalculator calc = null;

    @Test
    void below_absolute_zero(){
        Assertions.assertThrows(AbsoluteZeroException.class,()->{
            calc.farenheitToCelcius(-999.99);
        });
    }

    @Test
    void at_absolute_zero(){
        Assertions.assertThrows(AbsoluteZeroException.class,()->{
            calc.farenheitToCelcius(-459.67);
        });
    }

    @Test
    void just_above_absolute_zero(){
        double actual = calc.farenheitToCelcius(-459.66);
        Assertions.assertEquals(-273.144444, actual);
    }
    @Test
    void zero_farenheit(){
        double actual = calc.farenheitToCelcius(0);
        Assertions.assertEquals(-17.7778, actual);
    }

    @Test
    void hot(){
        double actual = calc.farenheitToCelcius(100);
        Assertions.assertEquals(37.7778, actual);
    }
}


```

## Good Unit Tests
- Indpendent
  - Are not dependent on code outside of the function being tested
- Small
  - Cover a single function/method
- Avoid side effects
  - Edit files on a computer or database
    - Think infinitely repeatable (idempotent)
- Each range of inputs is tested
  - Boundary values are tested
    - Common input problems like empty strings, lists and 0 are tested
  - Postive and negative paths are tested
- Test For one specific use case
## Bad Unit Tests
- Repeated tests with similar inputs
- Try to check for multiple things at once
- Test several functions at once
- Are flaky
  - Sometimes pass sometimes fail
- Test for things that are programmatically enforced
  - Check that a field is *really* on a class in strongly typed programming language 

### Unit Test Checklist
- [ ] Is there an input for every range of values?
  - This covers *Positive Tests* of valid inputs
  - This covers *Negative Test* of invalid inputs
- [ ] Does each unit test have only one assertion?
- [ ] Are your unit tests repeatable?
  - You get the same result every time
  - There is outside variable or condition that affects the test
- [ ] Do you have inputs that test the boundaries
  - At the boundary?
  - Just above and below the boundary?
- [ ] Do you have tests for inputs that commonly cause programming mistakes?
  - numbers
    - 0, 
    - negative values where postive is expected
  - strings
    - empty strings 
    - unexpected characters
  - null
- [ ] Do your unit tests cover every conditional and line of code?
  - Are there any lines of code that are never called by any test?
  - This testing of internal code flow/structure is *whitebox testing* 

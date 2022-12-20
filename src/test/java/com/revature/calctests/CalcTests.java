package com.revature.calctests;


import com.revature.calculators.AbsoluteZeroException;
import com.revature.calculators.TemperatureCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

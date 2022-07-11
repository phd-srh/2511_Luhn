package model;

import org.junit.Assert;
import org.junit.Test;

public class TestLuhn {

    @Test
    public void testCheckLong() {
        Assert.assertTrue( Luhn.check(18937) );
        Assert.assertFalse( Luhn.check(18930) );
        Assert.assertTrue( Luhn.check(1104942) );
    }

    @Test
    public void testCheckString() {
        Assert.assertTrue( Luhn.check("18937") );
        Assert.assertFalse( Luhn.check("18930") );
        Assert.assertTrue( Luhn.check("446667651") );
        Assert.assertTrue( Luhn.check("4563960122001999") );
        Assert.assertFalse( Luhn.check("12345678") );
    }

    @Test
    public void testGenerate() {
        String number = "123";
        Assert.assertFalse( Luhn.check(number) );
        number = Luhn.generate(number);
        Assert.assertTrue( Luhn.check(number) );
    }
}

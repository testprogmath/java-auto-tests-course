package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test
    public void testPrime() {
        Assert.assertTrue(Primes.IsPrime(Integer.MAX_VALUE));
    }
    @Test
    public void testPrimeFast() {
        Assert.assertTrue(Primes.IsPrimeFast(Integer.MAX_VALUE));
    }
    @Test
    public void testNotPrime() {
        Assert.assertFalse(Primes.IsPrime(Integer.MAX_VALUE-1));
    }
    @Test(enabled = false)
    public void testPrimeLong() {
        long n=Integer.MAX_VALUE;
        Assert.assertTrue(Primes.IsPrimeWhile(n));
    }
}

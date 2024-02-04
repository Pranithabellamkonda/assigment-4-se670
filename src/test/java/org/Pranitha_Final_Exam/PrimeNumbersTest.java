package org.Pranitha_Final_Exam;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    @Test
    public void doesNotReachFault(){
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(5);

        Iterator<Integer> iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            Integer prime = iterator.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }

        String primesAsString = primeNumbers.toString();
        assertEquals("[2, 3, 5, 7, 11]", primesAsString);
    }

    @Test
    public void reachFaultWithoutInfection(){
        PrimeNumbers primeNumbers = new PrimeNumbers();

        primeNumbers.computePrimes(10);

        Iterator<Integer> iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            int prime = iterator.next();
            assert prime % 10 != 9 : "Prime number ends with 9";
        }

        String primesString = primeNumbers.toString();
        assert !primesString.contains("9") : "String representation contains a number ending with 9";
    }

    @Test
    public void infectsStateDoesNotPropagate(){
        PrimeNumbers primeNumbers = new PrimeNumbers();

        primeNumbers.computePrimes(5);

        Iterator<Integer> iteratorBeforeFault = primeNumbers.iterator();
        while (iteratorBeforeFault.hasNext()) {
            Integer prime = iteratorBeforeFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }

        primeNumbers.computePrimes(15);

        Iterator<Integer> iteratorAfterFault = primeNumbers.iterator();
        while (iteratorAfterFault.hasNext()) {
            Integer prime = iteratorAfterFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }

        String primesAsString = primeNumbers.toString();
        assertFalse(primeNumbers.toString().endsWith("9"));
    }
    @Test
    public void propagatesNotReveal(){
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(5);

        Iterator<Integer> iteratorBeforeFault = primeNumbers.iterator();
        while (iteratorBeforeFault.hasNext()) {
            Integer prime = iteratorBeforeFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }
        primeNumbers.computePrimes(15);

        Iterator<Integer> iteratorAfterFault = primeNumbers.iterator();
        while (iteratorAfterFault.hasNext()) {
            Integer prime = iteratorAfterFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }
        Iterator<Integer> iteratorAfterPropagation = primeNumbers.iterator();
        while (iteratorAfterPropagation.hasNext()) {
            Integer prime = iteratorAfterPropagation.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }
    }
    @Test
    public void revealsFault(){
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(5);

        Iterator<Integer> iteratorBeforeFault = primeNumbers.iterator();
        while (iteratorBeforeFault.hasNext()) {
            Integer prime = iteratorBeforeFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }
        primeNumbers.computePrimes(20);

        Iterator<Integer> iteratorAfterFault = primeNumbers.iterator();
        while (iteratorAfterFault.hasNext()) {
            Integer prime = iteratorAfterFault.next();
            assertNotNull(prime);
            assertFalse(prime.toString().endsWith("9"));
        }

        String primesAsString = primeNumbers.toString();
        assertFalse(primesAsString.contains("9"));
    }

}
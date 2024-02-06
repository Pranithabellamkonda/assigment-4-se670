package org.Pranitha_Final_Exam;
import org.Pranitha_Final_Exam.PrimeNumbers;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;
class PrimeNumbersTest {
    @Test
    public void testDoesNotReachFault() {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(5);
        Iterator<Integer> iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            Integer prime = iterator.next();
            assertNotNull(prime);
        }
        String primesAsString = primeNumbers.toString();
        assertEquals("[2, 3, 5, 7, 11]", primesAsString);
    }
    @Test
    public void testReachFault() {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        primeNumbers.computePrimes(10);

        Iterator<Integer> iterator = primeNumbers.iterator();
        while (iterator.hasNext()) {
            Integer prime = iterator.next();
            assertNotNull(prime);
        }
        String primesAsString = primeNumbers.toString();
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]", primesAsString);
    }
}
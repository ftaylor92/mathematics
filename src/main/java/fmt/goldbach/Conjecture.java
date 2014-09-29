package fmt.goldbach;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.jsp.JspWriter;

import fmt.euclid.InfinitePrime;
import fmt.fermat.TwoSquare;

/**
 * @author root
 **/
public class Conjecture {
	/**
	 * main().
	 * @param args
	 **/
	public static void main(String[] args) {
		//goldbachConjecture(100000);
	}
	
	/**
	 * Goldbach conjecture: All primes are two primes added.
	 * Prove it!
	 * This demonstration proves Goldbach false.
	 **/
	public static void goldbachConjecture(long max, JspWriter out) throws IOException {
		long j= 3;
		while(j < max) {
			j= InfinitePrime.nextPrime(j);
			
			long[] twoIntegers= findTwoPrimesWhichAddToPrime(j);
			if(0 == twoIntegers[0]) {
				out.println(String.format("\n%3d == %2d + %2d!!!<br/>\n", j, twoIntegers[0], twoIntegers[1]));						
			} else {
				out.println(String.format("\n%3d == %2d + %2d<br/>\n", j, twoIntegers[0], twoIntegers[1]));
			}
			TwoSquare.sleep(5);
		}
	}
	
	/**
	 * Finds the two integers which, when added, add up to currentPrime 
	 * @param currentPrime prime number
	 * @return array of two integers which, when added, add up to currentPrime, else return two 0s
	 **/
	public static long[] findTwoPrimesWhichAddToPrime(long currentPrime) {
		long[] twoIntegers= new long[2];
		twoIntegers[0]= 0L;
		twoIntegers[1]= 0L;
		
		if(currentPrime < 3)	return twoIntegers;
		
		for(long i= 1; i < currentPrime; i++) {
			if(TwoSquare.isPrime(BigInteger.valueOf(i))) {
				for(long j= 1; j < currentPrime; j++) {
					if(TwoSquare.isPrime(BigInteger.valueOf(j))) {
						if(currentPrime == (i+ j)) {
							twoIntegers[0]= i;
							twoIntegers[1]= j;
							return twoIntegers;
						}
					}
				}
			}
		}
		
		return twoIntegers;
	}
}

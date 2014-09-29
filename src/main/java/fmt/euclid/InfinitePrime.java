/**
 * 
 */
package fmt.euclid;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import fmt.fermat.TwoSquare;

/**
 * @author root
 **/
public class InfinitePrime {

	/**
	 * main().
	 * @param args
	 **/
	public static void main(String[] args) {
		System.out.println(euclidPrimes(2000));
		System.out.println(infinitePrimes(9999999, 10000000));
	}
	
	/** Are there infinite primes?
	 * Prove it!
	 **/
	public static String infinitePrimes(long start, long max) {
		String allPrimes= String.format("all primes between %d and %d: ", start, max);
		long j= start;
		while(j < max) {
			j= nextPrime(j);
			allPrimes+= String.format("%d, ", j);
		}
		
		return allPrimes;
	}
	
	/**
	 * Euclid said that there are infinite primes because (all previous primes multiplied+1) is the next prime.
	 * Prove it!
	 * This demonstration proves that Euclid was wrong.
	 **/
	public static String euclidPrimes(long max) {
		String all= "Euclid said that there are infinite primes because (all previous primes multiplied+1) is the next prime.<br/>\n";
		all+= "This demonstration proves that Euclid was wrong.<br/>\n";
		List<Long> allPrimes= new ArrayList<Long>();
		List<Long> allNonPrimes= new ArrayList<Long>();
		allPrimes.add(2L);
		allPrimes.add(3L);
		allPrimes.add(7L);
		
		long j= 5;
		while(j < max) {
			j= nextPrime(allPrimes);
			for(long pr : allPrimes) {
				all+= pr+ " * ";
			}
			if(TwoSquare.isPrime(BigInteger.valueOf(j))) {
				allPrimes.add(j);
				all+= String.format("1 + 1 = %d<br/>\n", j);
				System.out.println(all);
			} else {
				if(!allNonPrimes.contains(j)) {
					all+= String.format("1 + 1 = %d; \t %d is not prime!!!<br/>\n", j, j);
					System.out.println(all);
				}
				allNonPrimes.add(j);
				
			}
			//TwoSquare.sleep(3);
		}
		
		return all;
	}
	
	public static long nextPrime(List<Long> currentPrimes) {
		long i= 1L;
		
		for(long l : currentPrimes) {
			i*= l;
		}
		
		return i+ 1;
	}

	public static long nextPrime(long currentPrime) {
		long i= currentPrime+ 1;
		for(; !TwoSquare.isPrime(BigInteger.valueOf(i)); i++);
		
		return i;
	}
}

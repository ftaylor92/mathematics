/**
 * 
 */
package fmt.fermat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author root
 **/
public class TwoSquare {
	public static List<Long> allPrimes= new ArrayList<Long>();
	public static List<Long> all1Primes= new ArrayList<Long>();
	public static List<Long> all3Primes= new ArrayList<Long>();
	public static List<Long> allGaps= new ArrayList<Long>();
	public static List<Long> allCubedFactors= new ArrayList<Long>();
	
	
	/**
	 * main().
	 * @param args
	 **/
	public static void main(String[] args) {
		fermatTwoSquareProblem();
		//TODO: analysisOnLists();
	}

	/**
	 * Fermat's Two Square problem: All primes divided by 4 either have a 1 or 3 remainder.
	 * Primes with a 1 remainder are equal to 2 squared integers added together.
	 * Prove it!
	 **/
	public static void fermatTwoSquareProblem() {
		for(long i= 1; i < 1000; i++) {
			if(isPrimeWeb(BigInteger.valueOf(i))) {
				allPrimes.add(i);
				if(allPrimes.size() > 1)	allGaps.add(i- allPrimes.get(allPrimes.size()-2));
				System.out.print(i+ ", ");
				if(1 == (i%4)) {
					long[] twoIntegers= findTwoSquares(i);
					if(0 == twoIntegers[0]) {
						System.err.printf("\n%3d == %2d^2 + %2d^2, ", i, twoIntegers[0], twoIntegers[1]);						
					} else if(1 == twoIntegers[0]) {
						System.out.printf("\n%3d == %2d^2 + %2d^2*, ", i, twoIntegers[0], twoIntegers[1]);
					} else {
						System.out.printf("\n%3d == %2d^2 + %2d^2, ", i, twoIntegers[0], twoIntegers[1]);
					}
					all1Primes.add(twoIntegers[0]);all1Primes.add(twoIntegers[1]);
					allCubedFactors.add(twoIntegers[0]);allCubedFactors.add(twoIntegers[1]);
				} else if(3 == (i%4)) {
					long[] twoIntegers= findTwoSquares(i);
					if(0 != twoIntegers[0]) {
						System.err.printf("\n%3d == %2d^2 + %2d^2!!!, ", i, twoIntegers[0], twoIntegers[1]);						
					}
					all3Primes.add(twoIntegers[0]);all3Primes.add(twoIntegers[1]);
					allCubedFactors.add(twoIntegers[0]);allCubedFactors.add(twoIntegers[1]);
				} else {
					System.err.print(i+ "!!!, ");
				}
			}
			sleep(2);
		}
	}
	
	/**
	 * Determines if number is prime.
	 * @param number which number to determine if prime
	 * @return whether number is prime
	 **/
	public static boolean isPrime(BigInteger number) {
		
		for(BigInteger i= BigInteger.valueOf(2L); i.compareTo(number) == -1; i= i.add(BigInteger.ONE)) {
			if(number.mod(i).compareTo(BigInteger.ZERO) == 0)	return false;
		}
		return true;
	}

	public static boolean isPrimeWeb(BigInteger n) {
		System.out.println("n: "+ n);
		if(n.compareTo(BigInteger.valueOf(2L)) == -1) return false;
		if(n.compareTo(BigInteger.valueOf(2L)) == 0 || n.compareTo(BigInteger.valueOf(3L)) == 0) return true;
		if(n.mod(BigInteger.valueOf(2L)).compareTo(BigInteger.ZERO) == 0 || n.mod(BigInteger.valueOf(3L)).compareTo(BigInteger.ZERO) == 0) return false;
		long sqrtN = (long)Math.sqrt(n.longValue())+1;
		for(long i = 6L; i <= sqrtN; i += 6) {
			if(n.mod(BigInteger.valueOf(i-1L)).longValue() == 0 || n.mod(BigInteger.valueOf(i+1L)).longValue() == 0) return false;
		}
		return true;
	}


	/**
	 * Finds the two integers which, when squared, add up to squareNum 
	 * @param squareSum sum
	 * @return array of two integers which, when squared, add up to squareSum, else return two 0s
	 **/
	public static long[] findTwoSquares(long squareSum) {
		long[] twoIntegers= new long[2];
		twoIntegers[0]= 0L;
		twoIntegers[1]= 0L;
		
		if(squareSum < 3)	return twoIntegers;
		
		for(long i= 1; i < squareSum; i++) {
			for(long j= 1; j < squareSum; j++) {
				if(squareSum == (Math.pow(i, 2)+ Math.pow(j, 2))) {
					twoIntegers[0]= i;
					twoIntegers[1]= j;
					return twoIntegers;
				}
			}
		}
		
		return twoIntegers;
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
			System.out.flush();
			System.err.flush();
		} catch(InterruptedException ex) {
			System.err.println(ex);
		}
	}
}

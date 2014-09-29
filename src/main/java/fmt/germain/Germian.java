/**
 * 
 */
package fmt.germain;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.jsp.JspWriter;

import fmt.fermat.TwoSquare;

/**
 * @author root
 **/
public class Germian {

	/**
	 * main().
	 * @param args
	 **/
	public static void main(String[] args) throws IOException {
		/*nextPrimeArchimedes(BigInteger.valueOf(53L), System.err);
		infinitePrimes(20, System.out);*/
	}

	/**
	 * Sophie Germain Primes: Archimedes said: if p is prime, so is a number between p and 2*(all primes multiplied by each other)+1 infinitely.
	 * Cannot prove Archimedes wrong logically.
	 * This demonstration proves Germian false.
	 **/
	public static void infinitePrimes(long iters, JspWriter out) throws IOException {	//PrintWriter
		BigInteger j= BigInteger.valueOf(3L);
		out.println("<table border='1'><tr><th>previous prime</th><th>(all primes multiplied by each other)+1</th><th>next Prime</th></tr><tr><td>1</td><td>1</td><td>2</td></tr><tr><td>2</td><td>2</td><td>3</td></tr>");
		while(j.compareTo(BigInteger.valueOf(iters)) == -1) {
			out.println("<tr><td>"+j+"</td>");
			j= nextPrimeArchimedes(j, out);
			System.out.println("j: "+ j);
			if(TwoSquare.isPrimeWeb(j)) {
				out.println(String.format("<td>%d</td>\n", j));
			} else if(j.compareTo(BigInteger.ZERO) != 0) {
				out.println(String.format("<td>%d is not prime</td>\n", j));
			} else {
				out.println(String.format("<td>%d violates Archimedes.</td>\n", j));
				break;
			}
			//TwoSquare.sleep(5);
			out.println("</tr>");
		}
		out.println("</table>");
	}
	
	/**
	 * Archimedes said there will always be a prime between the last highest prime and (all the previous primes multiplied *2)+ 1
	 * @param currentPrime current highest prime
	 * @return next prime in order, or 0 if none before Archimedes' prediction.
	 **/
	public static BigInteger nextPrimeArchimedes(BigInteger currentPrime, JspWriter out) throws IOException {
		BigInteger productOfAllPreviousPrimes= BigInteger.valueOf(2L);
		
		for(BigInteger j= BigInteger.valueOf(3L); j.compareTo(currentPrime) == -1 || j.compareTo(currentPrime) == 0; j= j.add(BigInteger.ONE)) {
			if(TwoSquare.isPrimeWeb(j))	productOfAllPreviousPrimes= productOfAllPreviousPrimes.multiply(j);
			if(productOfAllPreviousPrimes.compareTo(BigInteger.ZERO) == -1)	return BigInteger.valueOf(-1L);
		}
		
		BigInteger upperBound= productOfAllPreviousPrimes.multiply(BigInteger.valueOf(2L)); // + 1L;
		upperBound= productOfAllPreviousPrimes.add(BigInteger.ONE);
		System.out.println("upperBound: "+ upperBound);
		out.println(String.format("<td>%d</td>", upperBound));
		BigInteger i= currentPrime;
		i= i.add(BigInteger.ONE);
		System.out.println("currentPrime: "+ currentPrime);
		for(; i.compareTo(upperBound) == -1; i= i.add(BigInteger.ONE)) {
			System.out.println("for i: "+ i);
			if(TwoSquare.isPrime(i))	return i;
		}
		
		return BigInteger.ZERO;
	}
}

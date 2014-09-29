/**
 * 
 */
package fmt.analysis;

import java.util.ArrayList;
import java.util.List;

import fmt.fermat.TwoSquare;

/**
 * @author root
 **/
public class MyAnalysis {

	/**
	 * @param args
	 **/
	public static void main(String[] args) {
		analyzePrimes();
	}

	public static void analyzePrimes() {
		TwoSquare.fermatTwoSquareProblem();
	
		long n= 0L;
		List<Long> gaps= analyseList("gaps", TwoSquare.allGaps, 1);
		
		for(int step= 1; step < 17; step++) {
			analyseList("all", TwoSquare.allPrimes, step);
			//analyseList("cube", TwoSquare.allCubedFactors, step);
			analyseList("1s", TwoSquare.all1Primes, step);
			analyseList("gaps", TwoSquare.allGaps, step);
			analyseList("gap2", gaps, step);
		}
	}
	
	public static List<Long> analyseList(String desc, List<Long> list, int step) {
		System.out.print("\n"+desc+"("+step+"):");
		List<Long> newList= new ArrayList<Long>();
		for(int i= 0; i < list.size(); i+= step) {
			newList.add(list.get(i));
			System.out.printf("%d, ", list.get(i));
		}
		
		return newList;
	}
}

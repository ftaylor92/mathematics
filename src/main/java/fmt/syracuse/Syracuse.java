package fmt.syracuse;

import java.io.PrintStream;

/**
 * Syracuse Problem.
 * see: http://www.encyclopediaofmath.org/index.php/Syracuse_problem
 * for any number x, if x is even then next = x/2, or if odd then next = 3*x + 1, sequence always ends in 4, 2, 1
 **/
public class Syracuse {

	public static void main(String[] a) {
		syracuse(18, System.out);
	}
	
	public static void syracuse(int seed, PrintStream out) {
		int[] lastThree= new int[3];
		lastThree[0]= seed;
		lastThree[1]= seed;
		lastThree[2]= seed;
		
		int lastNum= seed;
		
		boolean found= false;
		
		while(!found) {
			out.printf("%d, ", lastNum);
			
			final boolean isEven= ( lastNum % 2 ) == 0;
			
			if(isEven) {
				lastNum= (lastNum / 2);
			} else { //odd
				lastNum= (3*lastNum + 1);
			}
			
			//set last three
			lastThree[2]= lastThree[1];
			lastThree[1]= lastThree[0];
			lastThree[0]= lastNum;
			
			found= isFound(lastThree);
		}

		out.printf("%d, ", lastNum);
	}
	
	public static boolean isFound(int[] lastThree) {
		return ( (lastThree[2] == 4) && (lastThree[1] == 2) && (lastThree[0] == 1) ); 
	}
}


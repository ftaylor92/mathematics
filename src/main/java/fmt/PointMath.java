package fmt;

public class PointMath {

	public static void main(String[] args) {
		System.out.println(findPointBetweenTwoPoints(20.0, 10.0, 50.0, 40.0, 20.0));
	}
	
	/**
	 * @param a point A coordinates
	 * @param b point A coordinates
	 * @param c point B coordinates
	 * @param d point B coordinates
	 * @param D distance to point C
	 **/
   public static String findPointBetweenTwoPoints(double a,double b,double c,double d,double D) {
       // calculate distance between the two points
       double DT = Math.sqrt(Math.pow((c - a), 2) + Math.pow((d - b), 2));
      
       double x;
       double y;
       double T = D / DT;
      
       // finding point C coordinate
       x = (1 - T) * a + T * c;
       y = (1 - T) * b + T * d;
      
       return ("Point C coordinates:\n  x: " + x + "\n  y: " + y);
   }
}
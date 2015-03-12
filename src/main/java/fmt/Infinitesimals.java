package fmt;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Infinitesimals {
	public static void main(String[] args) throws InterruptedException {
		calculateSmallestNumber();
	}

	private static void calculateSmallestNumber() throws InterruptedException {
		BigInteger i= new BigInteger("1");
		BigInteger iOne= new BigInteger("1");
		BigInteger iTwo= new BigInteger("2");
		
		BigDecimal f= new BigDecimal(1.0);
		BigDecimal one= new BigDecimal(1.0);
		BigDecimal two= new BigDecimal(2.0);
		while(true) {
			//final String s= String.format("%f", 1/f);
			//final String s= String.format("%f", f);
			//final String s= String.format("%f", one.divide(f));
			final String s= String.format("%f", f);
			final String is= String.format("%d", i);
			//final String s= String.format("%f", f);
			//System.out.println(s);
			System.out.printf("%s\n%s\n", is, s);
			f= f.multiply(two);
			i= i.multiply(iTwo);
			if(s.equals("Infinity") || s.equals("0.000000") || s.length() > 1000 || !s.startsWith(is)) break;
			
			//Thread.currentThread().sleep(1);
		}
	}
	
	//double:
	//0.000001
	//89884656743115800000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.000000
	//1253013342338661409303660896775775771737244047181178874727716412711542696032750356847731819088785102790229819123347051704425092173556032111131055953628337044481633245582682516578830204823494761531635951528829502473195894358116965356692220925232694852471354745213356064045216188970353693628521049471898563438044847774573122192980173991283947895554520753036151128813376592583533464726164815988286777913664030899865055559038032139937609240077221920922728815357914771760100600523198814885391032557128838283466760457104349598889953848044271000501145997011851579417608416156160714620242660104125092341848884564335327419194436424678224073865615516067919111865073421025000395814100193567672239512867642111808397286655068789781606535576326751936099169968856970846139439944691582641557503094461460960524343165773094980575142013121575465788639416039046393255462355002764651830494387734716529783332882463205304332916298958110635503113783034942703377639973563515367787437684611941154006628100155836033138688.000000

}
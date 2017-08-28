package HuaWei;
import java.util.Scanner;


public class 单词前缀 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		while(in.hasNext()){
			int arrNum = in.nextInt();
			int allNum = in.nextInt();
			int testNum = in.nextInt();
			String[][] biaoZu = new String[arrNum][allNum];
			String[][] testZu = new String[arrNum][testNum];
			//in.nextLine();
			for (int j = 0; j <arrNum; j++) {				
				
				String[] strings = new String[allNum];
				String[] testStrings= new String[testNum];
				for (int i = 0; i < allNum; i++) {					
					strings[i]=in.next();										
				}
				biaoZu[j]= strings;
				for (int i = 0; i < testNum; i++) {
					testStrings[i]= in.next();					
				}
				testZu[j]=testStrings;							
			}//输入完毕
			
			for (int j = 0;  j< arrNum; j++) {
				String[] strings = biaoZu[j];
				String[] testStrings= testZu[j];
				for (int i = 0; i < testNum; i++) {
					int count = 0;
					for (int k = 0; k < allNum; k++) {
						if (strings[k].startsWith(testStrings[i])) {
							count++;
						}
					}
					if (i==0) {
						System.out.println("Case #"+j+":");
					}
					System.out.println(count);
				}
			}

		break;
		}
		

	}

}

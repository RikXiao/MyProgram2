package HuaWei;

import java.util.Scanner;

public class 游戏24点算法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int[] data = new int[4];
			for (int i = 0; i < data.length; i++) {
				data[i] = in.nextInt();
			}
			System.out.println(is24(data, 4));
			
		}
	}
	/*主要想法是 
    * 先对四个数中的任意两个数进行四则运算，得到的结果加剩余的两个数还有三个数 
    * 再对三个数中的任意两个数进行四则运算，得到的结果加剩余的一个数还有二个数 
    * 再对剩余的两个数进行四则运算，得到的结果如果是24，就说明该表达式能得到24，表达式正确； 
    * 如果结果不是24，则说明表达式不正确 */
	public static boolean is24(int[] data,int length){
		if (length==1) {
			return data[0]==24;
		}
		for (int i = 0; i < length; i++) {//记住在后面需要恢复现场
			for (int j = i+1; j < length; j++) {
				int a = data[i];
				int b = data[j];
				data[j]=data[length-1];
				data[i] = a+b;
				if (is24(data, length-1)) {
					return true;
				}
				data[i]=a-b;
				if (is24(data, length-1)) {
					return true;
				}
				data[i] = a*b;
				if (is24(data, length-1)) {
					return true;
				}
				if (b!=0) {
					data[i]=a/b;
					if (is24(data, length-1)) {
						return true;
					}
				}
				data[i]=a;      //这里恢复现场尤其重要；
				data[j]=b;
				
			}
		}
		return false;
		
	}

}

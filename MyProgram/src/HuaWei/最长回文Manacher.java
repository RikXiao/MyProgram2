package HuaWei;

import java.util.Scanner;

public class 最长回文Manacher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			StringBuilder s = new StringBuilder();
			s.append("#");
			for (int i = 0; i < input.length(); i++) {
				s.append(input.charAt(i));
				s.append("#");
			}
			String result = getMaxHui(s.toString());
			System.out.println(result);
		}

	}
    public static String getMaxHui(String input){
    	int length = input.length();
    	
    	if (length==0) {
			return "";
		}
    	char[] data = input.toCharArray();
    	int[] result = new int[length];
    	//result[0]=1;
    	int maxRight = 0; //表示当前访问到的所有回文子串，所能触及的最右一个字符的位置。
    	int maxPos = 0; //MaxRight对应的回文串的对称轴所在的位置
    	int maxlen =0;
    	int start =0;
    	int end =0;
    	for (int i = 0; i < length; i++) {
			if (i<maxRight) {
				result[i] = Math.min(maxRight-i+1, result[2*maxPos-i]);
			}else{
				result[i]=1;
			}
			for (int j = i+result[i]; j < length&&(2*i-j)>=0; j++) {
				if (data[j]==data[2*i-j]) {
					result[i]++;
				}else{//记住不满足相等条件需要退出循环
					break;
				}				
			}
			if ((result[i]+i-1)>maxRight) {
				maxRight = result[i]+i-1;
				maxPos=i;
			}
			if (result[i]>maxlen) {
				maxlen = result[i];
				start = i-maxlen+1;
				end = i+maxlen;
			}
		}
    	
    	return input.substring(start, end);
    }
	
}

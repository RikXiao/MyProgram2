package NiuKe;


import java.util.Scanner;

public class Kolakoski序列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();//需要输出的前n项；
			int m = in.nextInt();//组成序列的数的个数m；
			int[] arr = new int[m];
			for (int i = 0; i < m; i++) {
				arr[i]=in.nextInt();
			}
			
			int[] out = new int[n];
			out[0] = arr[0];
			int tmpNum =1;//当前数字使用个数
			int index = 0;//当前正使用的数字下标
			int group = 0;//当前分组的下标从0开始
			for (int i = 1; i < n; i++) {				
				
				if (tmpNum<out[group]) {//如果当前组数的个数没有达到个数
					out[i] = arr[index%m];
					tmpNum++;
				}else {//如果达到了个数要求，则开始下一组数的放置
					index++;
					out[i] = arr[index%m];
					tmpNum = 1;
					group++;
					
				}
			}
			for (int i = 0; i < out.length; i++) {
				System.out.println(out[i]);
			}
		}

	}

}

package LeetCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 公交车行驶 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {//这种不确定输入有多少的最好是先把全部输入读完再输出
		//否则可能出错
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String intput = in.nextLine();
			String[] strs = intput.split(",");
			int N = Integer.valueOf(strs[0]);
		
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = df.parse(strs[1]);
			Date end = df.parse(strs[2]);
			int len = strs[1].length();
			
			long diff = end.getTime()-start.getTime();
			long fenzhong = diff/(1000*60);
			if (fenzhong<0||N<3||strs[1].charAt(len-1)!='0'||strs[1].charAt(len-2)!='0'||strs[2].charAt(len-1)!='0'||strs[2].charAt(len-2)!='0') {
				System.out.println("incorrect data");
			}else {
				//每经过15分中到达下一个站
				int a = (int)fenzhong/15;//总共的站数
				int left = (int)fenzhong%15;//到达站后还有几分钟
				int tmp = a/N+1;//当前的圈数
				int last = a%N+1;//最后一站
				if (last==N+1) {
					last = 1;
				}
				String outString = tmp+";";
				if (left>5) {
					int next = last+1;
					if (last+1==N+1) {
						next = 1;
					}
					outString+=last+"-"+next;
				}else {
					outString+=last+"-"+last;
				}
				System.out.println(outString);
			}
			
		}

	}

}

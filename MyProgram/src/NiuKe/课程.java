package NiuKe;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class 课程 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = Integer.valueOf(in.nextLine());
			HashMap<String, String> map = new HashMap<>();//保存时间和相应的课程
			TreeSet<String> timeSet = new TreeSet<>();//保存上课时间
			boolean flag = true;//表示没有冲突
			for (int i = 0; i < n; i++) {
				String string = in.nextLine();
				String[] strs = string.split("\\s+");
				timeSet.add(strs[0]);
				String code = map.get(strs[0]);
				if (code == null) {
					map.put(strs[0], strs[1]);
				}else {
					map.put(strs[0], code+" "+strs[1]);
					flag = false;//有冲突
				}
			}
			if (flag) {
				System.out.println("YES");
			}else {
				for (String t:timeSet) {
					String  ke = map.get(t);
					if (ke.indexOf(" ")!=-1) {
						System.out.println(t+" "+ke);
					}
				}
			}
			
			
		}

	}

}

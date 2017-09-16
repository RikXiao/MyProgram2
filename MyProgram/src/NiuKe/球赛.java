package NiuKe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 球赛 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = Integer.valueOf(in.nextLine());
			String[] teams = new String[n];
			for (int i = 0; i < n; i++) {
				teams[i] = in.nextLine();
			}
			int allCompete = n*(n-1)/2;
			HashMap<String, Integer> mapScores = new HashMap<>();//存放得分数
			HashMap<String, Integer> mapJinQiu = new HashMap<>();//存放进球数
			for (int i = 0; i < allCompete; i++) {
				String[] str = in.nextLine().split(" ");
				String teamvs = str[0];
				String scorevs = str[1];
				String[] twoT = teamvs.split("-");
				String[] towS = scorevs.split(":");
				//处理第一只球队
				
				//处理第二只球队				
				//处理输赢
				if (Integer.valueOf(towS[0])>Integer.valueOf(towS[1])) {
					Integer score = mapScores.get(twoT[0]);
					if (score==null) {
						mapScores.put(twoT[0], 3);
					}else {
						mapScores.put(twoT[0], 3+score);
					}
					//输球的队伍
					Integer score1 = mapScores.get(twoT[1]);
					if (score1==null) {
						mapScores.put(twoT[1], 0);
					}else {
						mapScores.put(twoT[1], 0+score);
					}
					
					//净胜球数
					Integer num1 = mapJinQiu.get(twoT[0]);
					if (num1==null) {
						mapJinQiu.put(twoT[0],Integer.valueOf(towS[0])-Integer.valueOf(towS[1]));
					}else {
						mapJinQiu.put(twoT[0], num1+Integer.valueOf(towS[0])-Integer.valueOf(towS[1]));
					}
					
				}
				else if (Integer.valueOf(towS[0])<Integer.valueOf(towS[1])) {
					Integer score = mapScores.get(twoT[1]);
					if (score==null) {
						mapScores.put(twoT[1], 3);
					}else {
						mapScores.put(twoT[1], 3+score);
					}
					//输球的队伍
					Integer score1 = mapScores.get(twoT[0]);
					if (score1==null) {
						mapScores.put(twoT[0], 0);
					}else {
						mapScores.put(twoT[0], 0+score);
					}
					//净胜球数
					Integer num1 = mapJinQiu.get(twoT[1]);
					if (num1==null) {
						mapJinQiu.put(twoT[1],Integer.valueOf(towS[1])-Integer.valueOf(towS[0]));
					}else {
						mapJinQiu.put(twoT[1], num1+Integer.valueOf(towS[1])-Integer.valueOf(towS[0]));
					}
				}else {
					//平局各加1分
					Integer score = mapScores.get(twoT[0]);
					if (score==null) {
						mapScores.put(twoT[0], 1);
					}else {
						mapScores.put(twoT[0], 1+score);
					}
					Integer score1 = mapScores.get(twoT[1]);
					if (score1==null) {
						mapScores.put(twoT[1], 1);
					}else {
						mapScores.put(twoT[1], 1+score1);
					}
				}
				
			}
			//开始排序			
			for (int i = 0; i < n/2; i++) {
				String max = teams[i];
				int index = i;
				for (int j = i+1; j < n; j++) {
					if (mapScores.get(teams[j])>mapScores.get(max)) {
						max = teams[j];
						index = j;
					}
					else if(mapScores.get(teams[j])==mapScores.get(max)){
						if (mapJinQiu.get(teams[j])>mapJinQiu.get(max)) {
							max = teams[j];
							index = j;
						}
					}
				}
				teams[index] = teams[i];
				teams[i] = max;
			}
			for (int j2 = 0; j2 < n/2; j2++) {
				System.out.println(teams[j2]);
			}
		}
        in.close();
	}

}

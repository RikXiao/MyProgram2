package NiuKe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 中兴实力分组 {

	public int calculatePower(int numOfKids,int card,int[][] pair,int[] strength){
		//首先确定分组
		ArrayList<HashSet<Integer>> fenzu =new ArrayList<>();
		boolean[] pairFlag = new boolean[card];
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		//确定分组主程序
		for (int i = 0; i < card; i++) {
			set.clear();
			if (!pairFlag[i]) {
				set.add(pair[i][0]);
				set.add(pair[i][1]);
				queue.offer(pair[i][0]);
				queue.offer(pair[i][1]);
				pairFlag[i]=true;
				while(!queue.isEmpty()){
					int kid = queue.poll();
					ArrayList<Integer> pairsList = findPair(pair, kid, pairFlag);
					for (int j = 0; j < pairsList.size(); j++) {
						int next = pairsList.get(i);
						if(set.add(next)){
							queue.offer(next);
						}
					}
				}
				fenzu.add(new HashSet<>(set));
			}
		}
		//分组完成，求分组的最高分数
		int max =0;
		
		for (int i = 0; i < fenzu.size(); i++) {
			set = fenzu.get(i);
			int count =0;
			for (int index:set) {
				count+=strength[index];
			}
			if (count>max) {
				max = count;
			}
		}
		
		//用分组的最高分和剩下的单人组比
		for (int i = 0; i < strength.length; i++) {
			if (strength[i]>max) {
				max = strength[i];
			}
		}
		return max;
	}
	public ArrayList<Integer> findPair(int[][] pair,int kid,boolean[] flag){
		ArrayList<Integer> list= new ArrayList<>();
		for (int i = 0; i < pair.length; i++) {
			if (!flag[i]) {
				if (kid==pair[i][0]||kid==pair[i][1]) {
					list.add(pair[i][0]);
					list.add(pair[i][1]);
					flag[i] = true;
				}
			}
		}
		return list;
	}
}

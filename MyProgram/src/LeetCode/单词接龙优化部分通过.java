package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 单词接龙优化部分通过 {
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dot");
		dict.add("lot");
		dict.add("log");

		System.out.println(ladderLength(start, end, dict));
		
	}
/*	public int ladderLength(String start, String end, Set<String> dict) {
		  // Use queue to help BFS
		  Queue<String> queue = new LinkedList<String>();
		  queue.add(start);
		  queue.add(null);
		  
		  // Mark visited word
		  Set<String> visited = new HashSet<String>();
		  visited.add(start);
		  
		  int level = 1;
		  
		  while (!queue.isEmpty()) {
		    String str = queue.poll();
		    
		    if (str != null) {
		      // Modify str's each character (so word distance is 1)
		      for (int i = 0; i < str.length(); i++) {
		        char[] chars = str.toCharArray();
		        
		        for (char c = 'a'; c <= 'z'; c++) {
		          chars[i] = c;
		          
		          String word = new String(chars);
		          
		          // Found the end word
		          if (word.equals(end)) return level + 1;
		          
		          // Put it to the queue
		          if (dict.contains(word) && !visited.contains(word)) {
		            queue.add(word);
		            visited.add(word);
		          }
		        }
		      }
		    } else {
		      level++;
		      
		      if (!queue.isEmpty()) { 
		        queue.add(null);
		      }
		    }
		  }
		  
		  return 0;
		}*/
	public static int min =Integer.MAX_VALUE;
    public static int ladderLength(String start, String end, Set<String> dict) {
        Iterator<String> itr = dict.iterator();
        int count =0;
        while(itr.hasNext()){//去掉与首尾字符串相同的字符
        	String word = itr.next();
        	if (word.equals(start)||word.equals(end)) {
				itr.remove();
			}else {
				count++;
			}
        }
        //放入字符串数组
        String[] arr = new String[count+2];
       
        itr = dict.iterator();
        for (int i = 1; i < arr.length-1; i++) {
			arr[i] = itr.next();
		}
        arr[0] = start;
        arr[arr.length-1] = end;
        int flagLength =(int) Math.pow(2, arr.length);//太大了
        int[][] minL = new int[arr.length][flagLength];//保存中间结果的数组
        //初始化
        for (int i = 0; i < minL.length; i++) {			
				Arrays.fill(minL[i], -1);  //初始化和不能到达要区分开来			
		}
       
        boolean[] flag = new boolean[arr.length];//标志数组表示该字符串是否已经被用过了
        flag[0] = true;
       int result = ladderLength(minL, arr, 0,arr.length,flag);
   /*    for (int i = 0; i < flag.length; i++) {
		System.out.println(minL[i]);
	}*/
       if (result<Integer.MAX_VALUE) {
		return result;
	}else {
		return 0;
	}
       
}
//还差一个flag的状态信息（所以还是遍历吧）
	public static int ladderLength(int[][] minL, String[] arr, int left,int length,boolean[] flag) {
		int flagNum = getFlagNum(flag);
		if(left==length-1){
			minL[left][flagNum]=1;
			return 1;
		}
		
		if (minL[left][flagNum]>=0) {
			return minL[left][flagNum];
		}
		//如果不相等那就找剩下还没有被用过的字符串中，符合一次变化的
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {			
			if (!flag[i]&&isDis1(arr[left], arr[i])) {
				flag[i] = true;
				int dis = ladderLength(minL, arr, i, length, flag);
				if (dis<Integer.MAX_VALUE) {//用一个较大的数，但是不是max_Value，这样1+dis就不会出现负数，就可以去掉判断直接min
					ans = Math.min(ans, 1+dis);
				}
				minL[i][getFlagNum(flag)]=dis;
				flag[i] = false;
			}
		}
		 minL[left][flagNum] = ans;
		return ans;				
	}
  public static boolean isDis1(String word1,String word2){
	  if (word1.length()==word2.length()) {
		  int count=0;
		  for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i)!=word2.charAt(i)) {
				count++;
			}
		}
		  if (count==1) {
			return true;
		}
	  }
		return false;
	
  }
  public static int getFlagNum(boolean[] flag){
		String s = "";
		for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				s += "1";
			} else {
				s += "0";
			}
		}
	  return Integer.valueOf(s, 2);
  }
}

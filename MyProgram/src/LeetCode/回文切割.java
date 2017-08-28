package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class 回文切割 {
	public static void main(String[] args) {
		String aString = "aabaa";
		HashMap<String, Integer> map = new HashMap<>();
		
		System.out.println("");
		String[] s = new String[10];
		System.out.println(s[9]);
		int variable2 =1;
		int _d =1;
		
		
	}
//求所有可能
    public static ArrayList<ArrayList<String>> partition(String s) {
    	HashMap<String, ArrayList<ArrayList<String>>> map = new HashMap<>();
    	return partion(s, map);
    	    	
    }
    
    public static ArrayList<ArrayList<String>> partion(String s,HashMap<String, ArrayList<ArrayList<String>>> map){
    	ArrayList<ArrayList<String>> res = new ArrayList<>();
    	if (s==null||s.length()==0) {
    		res.add(new ArrayList<String>());
			return res;
		}
    	if (map.get(s)!=null) {
			return map.get(s);
		}
    	ArrayList<String> nextPaline = nextPaline(s);
    	for (int i = 0; i < nextPaline.size(); i++) {
			String word = nextPaline.get(i);
			int len = word.length();
			ArrayList<ArrayList<String>> tmpMap = partion(s.substring(len),map);
			for (int j = 0; j < tmpMap.size(); j++) {
				ArrayList<String> list = new ArrayList<>(tmpMap.get(j));
				list.add(0, word);
				res.add(list);
			}
    		
		}
    	map.put(s, res);
    	return res;
    }
    
    public static ArrayList<String> nextPaline(String s){
    	char[] arr = s.toCharArray();
    	ArrayList<String> set = new ArrayList<>();
    	for (int i = 0; i <arr.length; i++) {
			int left =0,right = i;
			boolean flag = true;
			while(left<=right){
				if (arr[left]!=arr[right]) {
					flag=false;
					break;
				}
				left++;
				right--;
			}
			if (flag) {
				set.add(s.substring(0,i+1));
			}
		}
    	return set;
    }
    //求最小切割次数
    public static int minNum(String s,HashMap<String, Integer> map){
    	if (s==null||s.length()==0) {
			return -1;//一定要是-1,作为如果剩下为0则前面字符串不要切，-1会使结果为0
		}
    	if (map.get(s)!=null) {
			return map.get(s);
		}
    	int min =1000000;
    	ArrayList<String> nextPaline = nextPaline(s);
    	for (int i = 0; i < nextPaline.size(); i++) {
			String word = nextPaline.get(i);
			int len = word.length();
			int tmp =1+ minNum(s.substring(len), map);
			if (tmp<min) {
				min = tmp;
			}
		}
    			
    	map.put(s, min);
    	return min;
    	
    	
    }
   
   
}

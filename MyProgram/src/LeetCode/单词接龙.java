package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 单词接龙 {
	public static void main(String[] args) {
		String start = "game";
		String end = "thee";
		Set<String> dict = new HashSet<>();
		dict.add("frye");
		dict.add("heat");
		dict.add("tree");
		dict.add("thee");
		dict.add("game");
		dict.add("free");
		dict.add("hell");
		dict.add("fame");
		dict.add("faye");
		Iterator<String> itr = dict.iterator();
		while(itr.hasNext()){
			String word = itr.next();
			if (word.equals("free")) {
				itr.remove();
				//dict.add(word);
			}
			
			//dict.add(word);
			
		}
		//System.out.println(ladderLength(start, end, dict));
		
	}

	public static int min =Integer.MAX_VALUE;
    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
			return 2;
		}
        ArrayList<String> list = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        ladderLength(start, end, dict, list,map);
		if (min<Integer.MAX_VALUE) {
			return min+2;
		}else {
			return 0;
		}
    	
    }
  public static boolean ladderLength(String start, String end, Set<String> dict,ArrayList<String> list,Map<String, Boolean> map) {
        if (!isDis1(start, end)) {
        	boolean result = false;
			for (String word:dict) {
				if (start.equals(word)) {
					map.put(word, true);
				}
				if (isDis1(start, word)&&(map.get(word)==null||map.get(word)!=true)) {
					list.add(word);
					map.put(word, true);
					result = ladderLength(word, end, dict,list,map);	
					map.put(word, false);
					list.remove(list.size()-1);
				}
			}
			return result;
		}else {
			int size = list.size();
			if (size<min) {
				min=size;
			}
			return true;
		}
    	
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
}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "a";
		Set<String> dict = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		dict.add("a");
		/*dict.add("cats");
		dict.add("dog");
		dict.add("sand");
		dict.add("and");*/
		//wordBreak(s, dict, "", list);
		System.out.println(wordBreak(s, dict));

	}
    public static void wordBreak(String s, Set<String> dict,String tmp,ArrayList<String> list) {
       String aString  =tmp;
       String bString  = s;
    	if (!s.equals("")) {
			for (String word: dict) {
				if (s.startsWith(word)) {
					tmp=tmp+word+" ";
					s = s.substring(word.length());
					wordBreak(s, dict, tmp, list);
					tmp = aString;
					s = bString;
				}
			}        	
		}else {
			list.add(tmp.trim());
			System.out.println(tmp);
			
		}
       	
   }
   
    //判断是否可以
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		boolean[] flag = new boolean[s.length()+1];
		flag[0] = true;
		for (int i = 0; i < flag.length-1; i++) {			
			for (int j = 0; j <= i; j++) {
				String childWord = s.substring(j,i+1);
				if (dict.contains(childWord)&&flag[j]) {
					flag[i+1] = true;
					break;
				}
			}
		}
		return flag[s.length()];
	}
    // 输出所有的可能
	

	public ArrayList<String> wordBreakII(String s, Set<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
	}

	private ArrayList<String> DFS(String s, Set<String> wordDict,
			HashMap<String, ArrayList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String subStr : wordDict) {
			if (s.startsWith(subStr)) {
				for (String str : DFS(s.substring(subStr.length()), wordDict,
						map)) {
					res.add(subStr + (str == "" ? "" : " ") + str);

				}

			}
		}
		map.put(s, res);
		return res;

	}

}

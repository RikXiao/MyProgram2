package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 单词接龙答案 {
	
	    public int ladderLength(String start, String end, Set<String> dict) {
	        if (dict == null) {
	            return 0;
	        }

	        if (start.equals(end)) {
	            return 1;
	        }
	        
	        dict.add(end);
	        dict.add(start);
	        
	        Queue<String> theQueue = new LinkedList<String>();
	        theQueue.offer(start);
	        
	        HashSet<String> set = new HashSet<String>();	        
	        set.add(start);
	        
	        int length = 1;
	        while(!theQueue.isEmpty()) {//按层搜索，直到不可以继续或者找到end（广度优先搜索）
	            length++;
	            int size = theQueue.size();
	            for (int i = 0; i < size; i++) {
	                String word = theQueue.poll();
	                for (String nextWord: getNextWords(word, dict)) {
	                    if (set.contains(nextWord)) {
	                        continue;
	                    }
	                    if (nextWord.equals(end)) {
	                        return length;
	                    }
	                    
	                    set.add(nextWord);
	                    theQueue.offer(nextWord);
	                }
	            }
	        }
	        return 0;
	    }

	    private String replace(String s, int i, char c) {
	        char[] chars = s.toCharArray();
	        chars[i] = c;
	        return new String(chars);
	    }
	    
	    private ArrayList<String> getNextWords(String word, Set<String> dict) {
	        ArrayList<String> nextWords = new ArrayList<String>();
	        for (char c = 'a'; c <= 'z'; c++) {
	            for (int i = 0; i < word.length(); i++) {
	                if (c == word.charAt(i)) {
	                    continue;
	                }
	                String nextWord = replace(word, i, c);
	                if (dict.contains(nextWord)) {
	                    nextWords.add(nextWord);
	                }
	            }
	        }
	        return nextWords;
	    }
	}


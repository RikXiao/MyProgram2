package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class 最小正整数 {

	/**
	 * @param args
	 */
	/*请完成下面这个函数，实现题目要求的功能
	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ 
	******************************开始写代码******************************/
	    static int findMinMis(int[] A) {
              HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
              int max = Integer.MIN_VALUE;
              for (int i = 0; i < A.length; i++) {
            	  if (A[i]>max) {
					max = A[i];
				  }
				  map.put(A[i], 1);
			  }
              int res = 0;
              for (int i = 1; i <=max+1; i++) {
				if (map.get(i)==null) {
					res = i;
					break;
				}
			 }
              return res;

	    }
	/******************************结束写代码******************************/


	    public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        int res;
	            
	        int _A_size = 0;
	        _A_size = Integer.parseInt(in.nextLine().trim());
	        int[] _A = new int[_A_size];
	        int _A_item;
	        for(int _A_i = 0; _A_i < _A_size; _A_i++) {
	            _A_item = Integer.parseInt(in.nextLine().trim());
	            _A[_A_i] = _A_item;
	        }
	  
	        res = findMinMis(_A);
	        System.out.println(String.valueOf(res));    

	    }
	}




package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 全排列 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<String> Permutation(String str){
		HashSet<String> set = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
	    if (str.length()==0) {
			return result;
		}
	    char[] arr = str.toCharArray();
	    Permutation(arr, 0, set);
	    result.addAll(set);
	    Collections.sort(result);
	    return result;
				
	}
	
	public static void Permutation(char[] arr,int i,HashSet<String> set){
		if (i==arr.length-1) {
			set.add(String.valueOf(arr));
		}else{
			for (int j = i; j < arr.length; j++) {
				swap(arr, i, j);
				Permutation(arr, i+1, set);
				swap(arr, i, j);
			}
		}
		
	}
	public static void swap(char[] arr,int i,int j){
		char thc = arr[i];
		arr[i] = arr[j];
		arr[j] = thc;
	}
}

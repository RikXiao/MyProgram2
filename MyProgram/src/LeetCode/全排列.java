package LeetCode;

import java.util.ArrayList;


public class 全排列 {

	public ArrayList<ArrayList<Integer>> permutations(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		permutations(num, 0, result);
		return result;
	}
    /*public void permutations(int[] num,int index,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
		if (index == num.length-1) {
			list.add(num[index]);
			ArrayList<Integer> tmp = new ArrayList<Integer>(list);
			list.remove(index);
			result.add(tmp);
		}
		for (int i = index; i < num.length; i++) {
			swap(num, index, i);
			list.add(num[index]);
			permutations(num, index+1, result,list);
			list.remove(index);
			swap(num, index, i);
		}
	}*/
    public void swap(int[] num,int i,int j){
    	int temp= num[i];
    	num[i] = num[j];
    	num[j] = temp; 
    }
    public void permutations(int[] num,int index,ArrayList<ArrayList<Integer>> result){
  		if (index == num.length-1) {
  			ArrayList<Integer> list = new ArrayList<Integer>();
  			for (int i = 0; i < num.length; i++) {
  				list.add(num[i]);
  			}
  			result.add(list);
  		}
  		for (int i = index; i < num.length; i++) {
  			swap(num, index, i);
  			permutations(num, index+1, result);
  			swap(num, index, i);
  		}
  	}
}

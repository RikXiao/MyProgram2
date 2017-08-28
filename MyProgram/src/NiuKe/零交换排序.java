package NiuKe;

import java.util.HashMap;

public class 零交换排序 {

	public void sort(int[] array, int len) {
        // 完成这个函数
		swapWithZero(array,len,array[0]);
		HashMap<Integer, Integer> indexMap = new HashMap<>();//key 数字，value表示下标
        for(int i =0;i<array.length;i++){
        	indexMap.put(array[i], i);
        }
        for (int i = 1; i < array.length; i++) {
			//第一步找到i对应的下标
        	int da = array[i];//当前在i位子上的数
        	int indexi = indexMap.get(i);
        	//将数i与0的位子交换
        	swapWithZero(array,len,i);       	
        	//将0与当前在i位子上的数交换位子       	
        	swapWithZero(array,len,array[i]);			
        	swapWithZero(array,len,i);
			indexMap.put(da, indexi);//当前数放入i以前的位子
			indexMap.put(i, i);
		}
    }
	public void swapWithZero(int[] arr ,int len ,int s){
		
	}
}

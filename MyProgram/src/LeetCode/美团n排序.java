package LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class 美团n排序 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] arr = new int[n];						
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
				
			}
		    Stack<Integer> minStack = new Stack<>();
		    
		    minStack.push(arr[n-1]);
		    for (int i = n-2; i >=0; i--) {
				if (arr[i]<=minStack.peek()) {
					minStack.push(arr[i]);
				}
			}
		    int index = 0;
		    int tmp = 0;
		    for (int i = 0; i < arr.length; i++) {
		    	if (!minStack.isEmpty()) {
		    		if (arr[i]==minStack.peek()) {
						minStack.pop();
					}else {
						tmp = arr[i];
						arr[i] = minStack.peek();
						index = i;					
						break;
					}
				}
				
			}
		    if (!minStack.isEmpty()) {
		    	 int min = minStack.peek();
				    for (int j = n-1; j >index; j--) {
						if (arr[j] == min) {
							arr[j] = tmp;
							break;
						}
					}
			}else {
				int e = arr[n-1];
				arr[n-1] = arr[n-2];
				arr[n-2] = e;
			}
		   		    
		    for (int i = 0; i < arr.length; i++) {				
				if (i==0) {
					System.out.print(arr[i]);
				}else {
					System.out.print(" "+arr[i]);
				}
			}

	}

}
	
}
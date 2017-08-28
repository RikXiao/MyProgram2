package HuaWei;


import java.util.Scanner;

public class 快速排序 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
		    String inputString = in.nextLine();
		    char[] inputArrs = inputString.toCharArray();
		    quikSort(inputArrs, 0, inputArrs.length-1);
		    System.out.println(String.valueOf(inputArrs));
		}
		in.close();
	}
	
	public static void quikSort(char[] Arrs,int left,int right){
		if(left<right) {
			char pivot = media(Arrs, left, right);
			int i=left;
			int j= right-1;
			while (i<j) {//在只有两个数进行排序的时候需要使用到，因为此时i=j如果执行下面的程序会导致排序错误（主要是++i）
				while(Arrs[++i]<pivot){}
				while(Arrs[--j]>pivot){}
				if (i<j) {
					char tem = Arrs[i];
					Arrs[i]=Arrs[j];
					Arrs[j]=tem;
				}
				else {
					break;
				}
			}
			Arrs[right-1]= Arrs[i];
			Arrs[i]=pivot;
			quikSort(Arrs, left, i-1);
			quikSort(Arrs, i+1, right);
		}
		
	}
	
	public static char media(char[] Arrs,int left,int right){
		int mediaIndex = (left+right)/2;
		if (Arrs[left]>Arrs[mediaIndex]) {
			char tem = Arrs[left];
			Arrs[left]=Arrs[mediaIndex];
			Arrs[mediaIndex]=tem;
		}
		if (Arrs[left]>Arrs[right]) {
			char tem = Arrs[left];
			Arrs[left]=Arrs[right];
			Arrs[right]=tem;
		} 
		if (Arrs[mediaIndex]>Arrs[right]) {
			char tem = Arrs[mediaIndex];
			Arrs[mediaIndex] = Arrs[right];
			Arrs[right] = tem;
		}
		char tem = Arrs[mediaIndex];
		Arrs[mediaIndex]=Arrs[right-1];
		Arrs[right-1]=tem;
		
		return tem;
	}
}
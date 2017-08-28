package HuaWei;

import java.util.Arrays;
import java.util.Scanner;

public class 多线程同步仅参考 {
	public char[] arr;
	public int index;
	public 多线程同步仅参考(char[] arr,int order) {
		this.arr=arr;
		this.index=order;
	}
	synchronized public void put(int order,char ch){
		while(index%4!=order){
			try {
				this.wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	
		System.out.print(ch);

		arr[index++]=ch;
       
		notifyAll();
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int num = in.nextInt();
			char[] arr = new char[num*4];
			多线程同步仅参考 source = new 多线程同步仅参考(arr, 0);
			source.new Mythread(source, 'A', 0, num).start();
			source.new Mythread(source, 'B', 1, num).start();
			source.new Mythread(source, 'C', 2, num).start();
			source.new Mythread(source, 'D', 3, num).start();
			//System.out.println(Arrays.toString(arr));
		}
		}
	class Mythread extends Thread{
		public 多线程同步仅参考 source;
		public char ch;
		public int order;
		public int num;
		Mythread(多线程同步仅参考 source,char ch,int order,int num){
			this.source=source;
			this.ch=ch;
			this.order = order;
			this.num = num;
		}
		public void run(){
			while(num>0){
				source.put(order, ch);
				num--;
			}
			
		}
	}
}

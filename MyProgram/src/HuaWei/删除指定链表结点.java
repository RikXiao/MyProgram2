package HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class 删除指定链表结点 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int num = sc.nextInt();
			int firstNode = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(firstNode);
			for (int i = 0; i < num - 1; i++) {
				int Node1 = sc.nextInt();
				int Node2 = sc.nextInt();
                if(list.contains(Node1)){
                   continue;
}
				int index = list.indexOf(Node2);
                if(index==-1){
                    continue;
                }

				list.add(index + 1, Node1);

			}
			int deleteNode = sc.nextInt();
			list.remove(list.indexOf(deleteNode));
			for (int i = 0; i < list.size() - 1; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println(list.get(list.size() - 1)+" ");
		}
		sc.close();
	}
}

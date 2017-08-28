package HuaWei;

import java.util.Scanner;

public class 扑克牌比较大小 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String all = "345678910JQKA2";
		while(in.hasNext()){
			String input = in.nextLine();
			String[] data = input.split("-");
			String[] pai1 = data[0].split(" ");
			String[] pai2 = data[1].split(" ");
		
		    if (pai1[0].equals("joker")||pai2[0].equals("joker")) {//有大小王
					System.out.println("joker JOKER");
				}
			else {
				if (pai1.length==pai2.length) {//同类型比较
					if (all.indexOf(pai1[0])>all.indexOf(pai2[0])) {
						System.out.println(data[0]);
					}else {
						System.out.println(data[1]);
					}
				}else {
					if (pai1.length==4) {
						System.out.println(data[0]);
					}else if (pai2.length==4)  {
						System.out.println(data[1]);
					}else {
						System.out.println("ERROR");
					}
				}
			}
	
		
		}

	}

}

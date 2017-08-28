package HuaWei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字符串加密 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String listing = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";		
		while(in.hasNext()){
			String key = in.nextLine().toUpperCase();//秘钥先统一使用大写，加密时再根据是否小写进行变换
			String data = in.nextLine();
			String keyDate = "";
			if (key.length()>0&&data.length()>0) {//秘钥和明文都不为空继续执行
				//获得新的变换表
				String newList=getNewList(key, listing);
				
				for (int i = 0; i < data.length(); i++) {
					Boolean flagOfLittle = false; 
					char chari = data.charAt(i);
					if (chari>='a'&&chari<='z') {
						flagOfLittle=true;
						chari =(char) (chari-32);//小写-32变大写
					}
					if (chari>='A'&&chari<='Z') {
						int index = listing.indexOf(chari);
						chari=newList.charAt(index);
						if (flagOfLittle) {
							chari =(char)(chari+32);//大写变小写
						}
					}
					//如果不是字母，那么直接保持原文
					keyDate+=chari;					
				}
				System.out.println(keyDate);
			}
		}
	}
	public static String getNewList(String key,String listing){
		//首先去除key里面的重复字符，然后去除listing里面在key里面已经出现的字符
		int length = key.length();
		String result ="";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++) {
			char chars= key.charAt(i);
			Integer num= map.get(chars);
			if (num==null) {
				result+=chars;
				listing = listing.replace(chars+"", "");
				map.put(chars, 1);	
			}
		}
		result = result+listing;
		return result;
	}
	

}

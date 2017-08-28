package HuaWei;

import java.util.Scanner;

public class IP格式及是否同网段 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String childIp = in.nextLine();
			String ip1String = in.nextLine();
			String ip2String = in.nextLine();
			int result = checkNetSegment(childIp, ip1String, ip2String);
			System.out.println(result);
		}
	}
     
	public static boolean isRightIp(String ipString){
		char[] Arr = ipString.toCharArray();
		for(int i=0;i<Arr.length;i++){
			if (Arr[i]>='0'&&Arr[i]<='9'||Arr[i]=='.') {//存在数字和点意外的字符都不是ip
				continue;
			}else {
				return false;
			}
		}
		String ipArr[]= ipString.split("\\.");
		if (ipArr.length==4) {
			for (int i = 0; i < ipArr.length; i++) {
				if (ipArr[i].equals("")) {//可能存在1..1.1；这种连续两个点的情况
					return false;
				}
				else{
					int num = Integer.valueOf(ipArr[i]);
					if (num>=0&&num<=255) {
						continue;
					}
					else {
						return false;
					}
				}
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean isRightChildIp(String ipString){//子网掩码可以是255.0
		char[] Arr = ipString.toCharArray();
		for(int i=0;i<Arr.length;i++){
			if (Arr[i]>='0'&&Arr[i]<='9'||Arr[i]=='.') {//存在数字和点意外的字符都不是ip
				continue;
			}else {
				return false;
			}
		}
			String ipArr[] = ipString.split("\\.");
			String binaryS="";
		       for (int i = 0; i < ipArr.length; i++) {
					int num = Integer.valueOf(ipArr[i]);
					String bString = Integer.toBinaryString(num);
					for (int j = 0; j < 8-bString.length(); j++) {
						bString="0"+bString;
					}
					binaryS+=bString;
				}
		      // System.out.println(binaryS);
		       int indexO = binaryS.indexOf("0");
		       int lastIndex1 = binaryS.lastIndexOf("1");
		       if (lastIndex1>indexO||indexO==0) {
					return false;
				}
		       return true;
				
	}
	
	public static int checkNetSegment(String mask,String ip1,String ip2){
		boolean isRightIp = isRightIp(ip1)&&isRightIp(ip2)&&isRightChildIp(mask);
		if (isRightIp) {
			String maskArr[] = mask.split("\\.");
			String ip1Arr[] = ip1.split("\\.");
			String ip2Arr[] = ip2.split("\\.");
			for (int i = 0; i < 4; i++) {
				int maskNum =0;
				if(i<maskArr.length){
					maskNum = Integer.valueOf(maskArr[i]);
				}				 
				int ip1Num = Integer.valueOf(ip1Arr[i]);
				int ip2Num = Integer.valueOf(ip2Arr[i]);
				if ((ip1Num&maskNum)==(ip2Num&maskNum)) {
					continue;
				}
				else {
					return 2;
				}
			}
			return 0;
		}else {
			return 1;
		}
	}
}

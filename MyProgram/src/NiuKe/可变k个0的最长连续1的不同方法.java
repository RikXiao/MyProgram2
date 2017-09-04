package NiuKe;


public class 可变k个0的最长连续1的不同方法 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "1110001011011";
		System.out.println(getMax(string, 1));
	}

	public static int getMax(String str,int k) {		
		if (str == null) {
			return 0;
		}
		int length = str.length();
		if (length<=k) {
			return 1;
		}
		char[] arr = str.toCharArray();
		String[] result = new String[length];//以i结尾包含k个0最长字串
		//int[] nums = new int[length];//以i结尾包含k个0最长字串
		if (arr[0]=='1') {
			result[0] = arr[0]+"";			
		}else {
			if (k>0) {
				result[0] = arr[0]+"";
			}else {
				result[0] = "";
			}
		}
		
		for (int i = 1; i < result.length; i++) { 
			if (arr[i]=='1') {
				result[i] = result[i-1]+arr[i];
			}else {
				int num = getnum0(result[i-1]);
				if (num<k) {
					result[i] = result[i-1]+arr[i];
				}else {
					int index = result[i-1].indexOf('0');
					result[i] = result[i-1].substring(index+1)+arr[i];
				}
			}
		}
		int maxlen = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[i].length()>maxlen) {
				maxlen = result[i].length();
			}
		}
		int count =0;
		for (int i = 0; i < result.length; i++) {
			if (result[i].length()==maxlen) {
				count++;
			}
		}
		return count;
	}
	
	public static int getnum0(String str){
		int count =0;
				
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch=='0') {
					count++;
				}
			}
		return count;
	}
}

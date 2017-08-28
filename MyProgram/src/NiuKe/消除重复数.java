package NiuKe;
import java.util.Scanner;

public class 消除重复数 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in );
		while (sc.hasNext()) {
			String str = sc.nextLine();
			char[] charArray = str.toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			HashMap<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < charArray.length; i++) {
				char ch = charArray[i];
				Integer num = map.get(ch);
				if (num==null) {
					list.add(ch);
					map.put(ch, 1);
				}
			}
			Collections.sort(list);
			String result ="";
			for (int i = 0; i < list.size(); i++) {
				result = list.get(i)+result;
			}
			System.out.println(result);*/
		
		Scanner in = new Scanner(System.in );
		while(in.hasNext()){
		
			String data = in.next();
			char[] arr = data .toCharArray();
			int len = arr.length;
			String[] tmp = new String[len];
			String result = maxString(arr, len, tmp);
			System.out.println(result);
		}
		in.close();
	}
	
	public static String maxString(char[] arr,int x,String[] tmp) {
		if (arr.length==1) {
			return String.valueOf(arr);
		}
		tmp[0] = arr[0]+"";
		for (int i = 1; i < tmp.length; i++) {
			String ch = arr[i]+"";
			if (!tmp[i-1].contains(ch)) {//如果不包含
				tmp[i] = tmp[i-1]+arr[i];
			}else {//如果包含那就看保留哪一个大
				long a = Long.valueOf(tmp[i-1]);
				String other = tmp[i-1].replace(ch, "")+ch;
				long b = Long.valueOf(other);
				if (b>a) {
					tmp[i] = other;
				}else {
					tmp[i] = tmp[i-1];
				}
			}
		}
		
		return tmp[arr.length-1];
	}
	
}

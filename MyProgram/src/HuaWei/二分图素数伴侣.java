package HuaWei;
import java.util.Arrays;
import java.util.Scanner;

public class 二分图素数伴侣 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int num = in.nextInt();
			int[] Arr = new int[num];
			int even =0;
			for (int i = 0; i < num; i++) {
				Arr[i]=in.nextInt();
				if (Arr[i]%2==0) {
					even++;
				}
			}
			if (even==0||even==num) {//全为奇数则没有素数伴侣
				System.out.println(0);
			}
			else { //将奇数放在前面，因为使用evenParter存放后面偶数的当前配对数时，遇到0课认为没有配对，
				//但是如果偶数放在前面，后面存放奇数的配对数时，遇到0无法判断是前面的偶数，还是没有配对。
				//（evenparter最后是存放的下标+1）（存放下标加1就无所谓奇数在前还是）
				int[] oddArr = new int[num-even];
				int[] evenArr = new int[even];
				int k=0,j=0;
				for (int i = 0; i < num; i++) {
					if (Arr[i]%2==0) {
						evenArr[k++]=Arr[i];
					}
					else {
						oddArr[j++]=Arr[i];
					}
				}
			
				boolean[] evenflag =new boolean[even];
				int[] evenParter = new int[even];
				int max=0;
				for (int i = 0; i < oddArr.length; i++) {
					Arrays.fill(evenflag, false);//每一次重新置所有标志位为false
					if (findPart(i, oddArr, evenArr, evenflag, evenParter)) {
						max++;
					}
				}
				System.out.println(max);

			}
		}
		in.close();
	}
	public static boolean findPart(int x,int[] oddArr,int[] evenArr,boolean[] evenflag,int[] evenParter) {
		for (int i = 0; i < evenArr.length; i++) {
			if (evenflag[i]==false&&isPart(oddArr[x], evenArr[i])) {//两个数可以组对，并且该偶数在本次中没有被选过
				evenflag[i] = true;
				if (evenParter[i]==0||findPart(evenParter[i]-1, oddArr, evenArr, evenflag, evenParter)) {//如果该偶数没有配过对，或者可以找到增广路径则可以配对
					evenParter[i] = x+1;//存放奇数下标加1；为了与0区别；	（用-1初始化就好了）				
					return true;
				}
			}			
		}
		return false;
	}
	public static boolean isPart(int a,int b) {
		int count = a+b;
		for (int i = 2; i*i <=count ; i++) {
			if (count%i==0) {
				return false;
			}
		}
		return true;
	}
}

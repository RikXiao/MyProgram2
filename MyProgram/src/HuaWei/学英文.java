package HuaWei;

import java.util.Scanner;

/**
 *  * 学英语  * @author Administrator  *  
 */
public class 学英文 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLong()) {
			String str = parse(sc.nextLong());
			System.out.println(str);
		}
		sc.close();
	}

	public static String parse(long num) {
		String result = "";
		String[] arr_ge = { "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		String[] arr_10_19 = { "ten", "eleven", "twelve", "thirteen",
				"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"ninteen" };
		String[] arr_shi = { "ten", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };
		if (num <= 999) {
			if (num == 0) {
				return "";
			}
			if (1 <= num && num <= 9) {
				return arr_ge[(int) (num - 1)];
			}
			if (10 <= num && num <= 19) {
				return arr_10_19[(int) (num - 10)];
			} else {
				if (19 <= num && num <= 99) {
					int shiwei = (int) num / 10;
					if (num % 10 != 0) {
						int gewei = (int) num % 10;
						return arr_shi[shiwei - 1] + " " + arr_ge[gewei - 1];
					} else {
						return arr_shi[shiwei - 1];
					}

				}
				if (100 <= num && num <= 999) {
					int bai = (int) num / 100;
					long other = num - bai * 100;
					return arr_ge[bai - 1] + " hundred and " + parse(other);
				}
			}
		} else {
			if (1000 <= num && num <= 999999) {
				int thousand_part = (int) num / 1000;
				long other = num - thousand_part * 1000;
				return parse(thousand_part) + " thousand " + parse(other);
			}
			if (1000000 <= num && num <= 999999999) {
				int million_part = (int) num / 1000000;
				long other = num - million_part * 1000000;
				return parse(million_part) + " million " + parse(other);
			} else {
				int billion_part = (int) num / 1000000000;
				long other = num - billion_part * 1000000000;
				return parse(billion_part) + " billion " + parse(other);
			}
		}
		return result;
	}
}
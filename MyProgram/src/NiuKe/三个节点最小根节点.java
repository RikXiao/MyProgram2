package NiuKe;


import java.util.Scanner;


public class 三个节点最小根节点 {

    public static int binarySearch(int a,int b,int c, int left, int right) {
        int m = left + (right - left) / 2;

        if((a - m) * (b - m) <= 0 || (a - m) * (c - m) <= 0 || (c - m) * (b - m) <= 0) {//是否分别位于中间节点两侧
            return m;
        } else if(a > m) {
            return binarySearch(a, b, c, m + 1, right);
        } else {
            return binarySearch(a, b, c, left, m - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(binarySearch(a, b, c, 1, (2 << k) - 1));
    }
}
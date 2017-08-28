package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class 之字形遍历 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[][] num = {{1, 2,  3,  4},
               {5, 6,  7,  8},
               {9,10, 11, 12}};
            之字形遍历 a = new 之字形遍历();
    a.printZMatrix(num);
	}
	public int[] printZMatrix(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[] result = new int[row*col];
		int index =0;//result索引变量
		int i=0,j=0;
		ArrayList<Integer> list = new ArrayList<>();
		for (i=0; i < row; i++) {//先从第一列从上往下
			int x =i,y=j;
			while(x>=0&&x<row&&y>=0&&y<col){
				list.add(matrix[x][y]);
				y++;//找到右上角的数字
				x--;
			}
			if ((x+y)%2==1) {//如果为奇数排，则从后往前遍历				
				for (int k = list.size()-1; k >=0; k--) {
					result[index++] = list.get(k);
				}
				list.clear();
			}else {//如果为偶数平排，就从前往后遍历
				for (int k = 0; k < list.size(); k++) {
					result[index++] = list.get(k);
				}
				list.clear();
			}
		}
		i = row-1;
		//然后从最后一行从左往右开始遍历
		for (j=1; j < col; j++) {
			int x =i,y=j;
			while(x>=0&&x<row&&y>=0&&y<col){
				list.add(matrix[x][y]);
				y++;//找到右上角的数字
				x--;
			}
			if ((x+y)%2==1) {//如果为奇数数排，则从后往前遍历				
				for (int k = list.size()-1; k >=0; k--) {
					result[index++] = list.get(k);
				}
				list.clear();
			}else {//如果为偶数数平排，就从前往后遍历
				for (int k = 0; k < list.size(); k++) {
					result[index++] = list.get(k);
				}
				list.clear();
			}
		}
		//遍历完输出结果
		System.out.println(Arrays.toString(result));
		return result;
    }

}

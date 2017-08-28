package LeetCode;

public class 在同一直线上的点的最大数 {
	public static void main(String[] args) {
		在同一直线上的点的最大数 a = new 在同一直线上的点的最大数();
		Point p1 = a.new Point(84, 250);
		Point p2 = a.new Point(0, 0);
		Point p3 = a.new Point(1, 0);
		Point p4 = a.new Point(0, -70);
		Point p5 = a.new Point(0, -70);
		Point p6 = a.new Point(1, -1);
		Point p7 = a.new Point(21, 10);
		Point p8 = a.new Point(42, 90);
		Point p9 = a.new Point(-42, -230);
		Point[] points = new Point[9];
		points[0] =p1;
		points[1] =p2;
		points[2] =p3;
		points[3] =p4;
		points[4] =p5;
		points[5] =p6;
		points[6] =p7;
		points[7] =p8;
		points[8] =p9;
		System.out.println(a.maxPoints(points));
	}
	
	public int maxPoints(Point[] points) {
		int length = points.length;
		if (length<=2) {
			return length;
		}
		int max =0;
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				if (i==3&&j==6) {
					int a =0;
				}
				int num = getOnLine(i, j, points);
				if (num>max) {
					max=num;
					//System.out.println(max);
				}
			}
		}
		
         return max;
	}
	//这里弄复杂了，其实就用交叉相乘相等判断斜率是否一样就可以，这样就避免了除数为0的情况
	
	public static int getOnLine(int index1,int index2,Point[] points){
		int result =2;
		if ((points[index1].x-points[index2].x)==0) {
			for (int i = 0; i < points.length; i++) {
				if (i==index1||i==index2) {
					continue;
				}else {
					if (points[i].x==points[index1].x) {
						result++;
					}
				}
			}
			return result;
		}
		double a1 = (points[index1].y-points[index2].y);
		double b1 = points[index1].x-points[index2].x;
		for (int i = 0; i < points.length; i++) {
			if (i==index1||i==index2) {
				continue;
			}else {
				if ((points[index1].x-points[i].x)==0&&points[index1].y-points[i].y==0) {
					result++;
				}else {
					double a = points[index1].y-points[i].y;
					double b = points[index1].x-points[i].x;
					
					if (a1*b==b1*a) {
						//System.out.println();
						result++;
					}
				}
				
				
			}
		}
		return result;
	}
	 
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
}

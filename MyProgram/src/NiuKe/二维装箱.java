package NiuKe;

import java.util.Scanner;



public class 二维装箱 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			   int a1 = in.nextInt();
			   int a2 = in.nextInt();
			   int a3 = in.nextInt();
			   int a4 = in.nextInt();
			   int a5 = in.nextInt();
			   int a6 = in.nextInt();
			  
			   if(a1 ==0 && a2==0 && a3==0 && a4==0 && a5==0 && a6==0){
				   break; 
			   }
			   int data1[] ={0,7,6,5};
			   
			   int data2[] ={0,5,3,1};
			   
			   int left1=0,left2=0;//left1表示还可以可以放1*1的个数，left2表示还可以放2*2的个数
			  
			   int sum = a6+a5+a4; 
			   sum = sum + a3/4;
			   if(a3%4!=0)
			    sum += 1;
			   left1 = 11*a5 + data1[a3%4];
			   left2 = a4*5+data2[a3%4];
			   
			   if(left2<a2){
			    a2 -= left2;
			    sum += a2/9;
			    if(a2%9!=0)
			     sum += 1;
			    left1 += (9 - a2%9)*4;
			   }
			   else{
			    left2 -= a2;
			    left1 += 4*left2;  
			   }
			   if(left1<=a1)
			   {
			    a1 -= left1;
			    
			    sum += a1/36;
			    if(a1%36!=0)
			     sum += 1;
			   }
			   System.out.println(sum);   
			  }
			 }
		

	}


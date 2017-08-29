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
			   int data1[] ={0,7,6,5};//表示装了三号箱子的大箱子还能装多少1号箱子
			   
			   int data2[] ={0,5,3,1};//表示装了三号箱子的大箱子还能装多少2号箱子
			   
			   int left1=0,left2=0;//left1表示还可以可以放1*1的个数，left2表示还可以放2*2的个数
			  
			   int sum = a6+a5+a4;     //规格4以上的都需要一个单独的箱子，
			   sum = sum + a3/4;      //规格为3的每4个可以组成一个打箱子
			   if(a3%4!=0)//剩下的3需要一个
			    sum += 1;
			   left1 = 11*a5 + data1[a3%4];
			   left2 = a4*5+data2[a3%4];
			   //先放2*2的，看剩余空间是否可以放心这么多2号箱子
			   if(left2<a2){//如果不可以，就要加
			    a2 -= left2;
			    sum += a2/9;
			    if(a2%9!=0)
			     sum += 1;
			    left1 += (9 - a2%9)*4;//新加的箱子又增加了1号箱子的位子
			   }
			   else{//如果2号箱子可以放到前面剩余空间里去
			    left2 -= a2;
			    left1 += 4*left2;  //把未放完的2号箱子的位子转换为1号箱子的位子
			   }
			   //放1号箱子，看剩余空间是否足够，不够就加
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


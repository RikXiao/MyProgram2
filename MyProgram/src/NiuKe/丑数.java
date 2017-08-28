package NiuKe;

public class 丑数 {
	  public int GetUglyNumber_Solution(int index) {
	        if(index<=0){
	            return 0;
	        }
	        
	        int[] array= new int[index];
	        if(index<=5){//1 2  3 4 5,是最小的5个丑数，也是最基础的5个，其他的都可以在这5个数的基础上求出来
	            return index;
	        }
	        array[0]=1;
	        array[1]=2;
	        array[2]=3;
	        array[3]=4;
	        array[4]=5;
	        
	        for(int i=5;i<index;i++)
	        {
	            int min=0;
	            int min2=0,min3=0,min5=0;
	            int temp=0;
	            for(int j=0;j<i;j++)
	            {
	                temp=array[j]*2;
	                if(temp>array[i-1])
	                {min2=temp;break;}
	            }
	           for(int j=0;j<i;j++)
	            {
	                temp=array[j]*3;
	                if(temp>array[i-1])
	                {min3=temp;break;}
	            }
	            for(int j=0;j<i;j++)
	            {
	                temp=array[j]*5;
	                if(temp>array[i-1])
	                { min5=temp;break;}
	            }
	           min=min2>min3?(min3>min5?min5:min3):(min2>min5?min5:min2);
	            array[i]=min;
	        }
	        return array[index-1];
	    }
	
}

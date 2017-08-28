package NiuKe;

public class 最短路径算法 {

	//总共n个点，求到原点v0的最短距离，v0代表的是原点的下标
	//dis表示个点到源点最短距离
	//A表示个点之间的距离，用integer.max_value表示无穷
	//pre，表示其最短路径的前一个点（前驱点下标//最后给其初始都为-1）
	//flag表示该店是否加入了源点一边的集合，是否已经被用了
	
	public void dijkstra(int[] dis,int[][] A,int[] pre,int n,int v0,boolean[] flag){
		//初始化dis,pre,flag(与v0比较)
		for (int i = 0; i < n; i++) {
			dis[i] = A[v0][i];
			flag[i] = false;
			if (dis[i]==Integer.MAX_VALUE) {
				pre[i]=-1;  //若没有到v0的直接边，则前驱点设为-1；
			}else {
				pre[i]=v0;  //若有到v0的直接边，则前驱点设为v0；
			}
		}
		//自己到自己距离设为0，并且设置标志位为true
		dis[v0]=0;
		flag[v0] = true;
		//开始循环计算所有点到源点v0的最短距离，这里并不是按顺序的，只是每一次计算出来一个点。
		for (int i = 1; i < n; i++) {//这里可以从1开始因为源点已经计算过了，只剩下n-1个点
			int TmpMin = Integer.MAX_VALUE;
			int u = v0;
			for (int j = 0; j < n; j++) {//计算出来剩余点距离最小的点
				if (!flag[j]&&dis[j]<TmpMin) {
					u=j;
					TmpMin = dis[j];
				}
			}
			flag[u] = true;
			for (int j = 0; j < flag.length; j++) {
				if (!flag[j]&&A[u][j]<Integer.MAX_VALUE) {//必须判断A[u][j]不是无穷，否则直接加可能超出范围变为负数					
					if (dis[u]+A[u][j]<dis[j]) {
						dis[j]=dis[u]+A[u][j];
						pre[j]=u;
					}
					
				}
			}
		}
		//结束
	}
}

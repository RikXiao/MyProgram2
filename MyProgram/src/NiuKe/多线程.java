package NiuKe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 多线程 {

	public ExecutorService executorService;
	
	public 多线程(){
		executorService = Executors.newFixedThreadPool(4);
	}
	
	public void add(){
		//executorService.execute();
	}
}

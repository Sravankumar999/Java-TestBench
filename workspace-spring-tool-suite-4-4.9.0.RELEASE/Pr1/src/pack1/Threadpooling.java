package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadpooling {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		for(int i=0;i<1000;i++) {
			Runnable runnable=new Runnable() {
				public void run() {
					System.out.println("Thread Number "+Thread.currentThread().getName());
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
		while(!executorService.isTerminated()) {}
		System.out.println("Completed");
	}
}
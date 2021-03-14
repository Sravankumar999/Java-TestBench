package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thred {
	public static void main(String[] args) {
		Thread th=new Thread() {
			public void run() {
				System.out.println("Thread method");
			}
		};
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		for(int i=0;i<20;i++) {
			executorService.execute(th);
			System.out.println(executorService.isShutdown());
		}
		executorService.shutdown();
		while(!executorService.isShutdown()) {}
		System.out.println(executorService.isShutdown());
	}
}

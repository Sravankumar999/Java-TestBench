package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Thr{
	public void set() {
		int c=0;
		System.out.println("Value of c is changed to "+c+" by "+Thread.currentThread().getName());
	}
	public void get() {
		System.out.println('0');
	}
}

public class Longs {
	public static void main(String[] args) {
		Thr t1=new Thr();
		ExecutorService executorService=Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++) {
			executorService.execute(()->{
				t1.set();
				t1.get();
			});
		}
	}
}

package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test{
	public void print(int n) {
		System.out.println(Thread.currentThread().getName()+" "+n);
	}
}

class Threadimpl extends Thread{
	Test t;
	int n;
	public Threadimpl(Test t, int n) {
		this.t=t;
		this.n=n;
	}
	public void run() {
		t.print(n);
	}
}

class Thrpool{
	public static void main(String[] args) {
		int avail=Runtime.getRuntime().availableProcessors();
		Test test=new Test();
		ExecutorService executorService=Executors.newFixedThreadPool(10);
		for(int i=0;i<15;i++) {
			executorService.submit(new Threadimpl(test, i));
		}
		
		System.out.println(avail);
	}
}
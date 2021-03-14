package pack1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Th1 implements Callable<Integer>{
	
	public Integer call(){	
		return new Random().nextInt(10);
	}

}

public class CallableThreadpools {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		Future<Integer> future =executorService.submit(new Th1());
		int a=future.get();
		System.out.println(a);
		}
}

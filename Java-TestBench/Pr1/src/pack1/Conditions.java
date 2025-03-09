package pack1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Testing{
	Lock lock=new ReentrantLock();
	Condition reading=lock.newCondition();
	Condition writing=lock.newCondition();
	int count=0;
	boolean readable=false;
	public void set() throws InterruptedException {
		lock.lock();
		while(readable) {
			writing.await();
		}
		count+=1;
		System.out.println("Setting to "+count);
		readable=true;
		reading.signalAll();
		lock.unlock();
	}
	public void get() throws InterruptedException {
		lock.lock();
		while(!readable) {
			reading.await();
		}
		System.out.println("The value of count is "+this.count);
		readable=false;
		writing.signalAll();
		lock.unlock();
	}
}

public class Conditions {
	public static void main(String[] args) {
		Testing testing=new Testing();
		new Thread(()->{
			try {
			for(int i=0;i<10;i++) {
				testing.set();
				Thread.sleep(100);
			}
			}catch(Exception e) {}
		}).start();
		new Thread(()->{
			try {
			for(int i=0;i<10;i++) {
				testing.get();
				Thread.sleep(2000);
			}
			}catch(Exception e) {}
		}).start();
	}

}

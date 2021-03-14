package pack1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class Base{
	//Lock lock=new ReentrantLock();
	ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	ReadLock readlock=lock.readLock();
	WriteLock writelock=lock.writeLock();
	int c=0;
	public void inc(){
		writelock.lock();
		c++;
		System.out.println("Incremented to "+this.c+" "+Thread.currentThread().getName());
		writelock.unlock();
	}
	public void returnvalue() {
		readlock.lock();
		System.out.println("Reading the value "+this.c+" "+Thread.currentThread().getName());
		readlock.unlock();
	}
}
public class Locks {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		Base b=new Base();
		Runnable r=()->b.inc();
		for(int i=0;i<10;i++) {
			executorService.submit(r);
			executorService.submit(()->b.returnvalue());
			executorService.submit(()->b.returnvalue());
		}
	}
}

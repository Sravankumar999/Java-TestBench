package pack1;

public class Multithreads extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		Multithreads t1=new Multithreads();
		Multithreads t2=new Multithreads();
		t1.start();
		t2.start();
	}
}

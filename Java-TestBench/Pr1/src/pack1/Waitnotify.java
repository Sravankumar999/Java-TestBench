package pack1;

class Data{
	int c=0;
	boolean got=true;
	synchronized public void get() throws InterruptedException {
		while(got) {
			wait();
		}
		System.out.println(c);
		got=true;
		notify();
	}
	synchronized public void set( int i) throws InterruptedException {
		while(!got) {
			wait();
		}
		c=i;
		got=false;
		notify();
		
	}
}


class Reader extends Thread{
	Data d;
	Reader(Data d){
		this.d=d;
	}
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				d.get();
			} catch (InterruptedException e1) {
			
				e1.printStackTrace();
			}
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
	}
}

class Writer extends Thread{
	Data d;
	Writer(Data d){
		this.d=d;
	}
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				d.set(i);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
	}
}

public class Waitnotify {
	public static void main(String[] args) {
		Data d=new Data();
		Reader r=new Reader(d);
		Writer w=new Writer(d);
		r.start();
		w.start();
	}
}

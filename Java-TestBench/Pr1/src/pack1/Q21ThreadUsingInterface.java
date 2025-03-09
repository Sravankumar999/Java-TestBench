package pack1;

public class Q21ThreadUsingInterface extends Thread{
    public void run(){
        for(int i=0;i<10;i++) {
        	System.out.println(Thread.currentThread().getName());
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    public static void main(String[] args){
        Q21ThreadUsingInterface t1 =new Q21ThreadUsingInterface();
        Q21ThreadUsingInterface t2 =new Q21ThreadUsingInterface();
        t1.start();
        t2.start();
    }
}

package pack1;


//class Th1 extends Thread{
//	Tab t;
//	Th1(Tab t){
//		this.t=t;;
//	}
//	
//	public void run() {
//		Tab.meth1();
//	}
//}
//
//class Th2 extends Thread{
//	Tab t;
//	Th2(Tab t){
//		this.t=t;;
//	}
//	
//	public void run() {
//		Tab.meth1();
//	}
//}
class Tab{
	void meth1() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
	}
}

public class Multiplethread {
	public static void main(String[] args) {
//		Tab t2=new Tab();
//		Th1 th1=new Th1(t);
//		Th2 th2=new Th2(
		//th1.start();
		//th2.start();
		Tab t=new Tab();
		new Thread(()->t.meth1(),"1st").start();
		new Thread(()->t.meth1(),"2nd").start();
				
		}
	
}
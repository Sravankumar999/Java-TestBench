class parent extends Thread{
	static InheritableThreadLocal<Integer> local=new InheritableThreadLocal<>();
	static ThreadLocal<Integer> value=new ThreadLocal<>();
	//static ThreadLocal<Integer> local3=ThreadLocal.withInitial(()->{return 2;});
	public void run() {
		local.set(100);
		value.set(200);
		System.out.println("Parent Thread Normal Local "+value.get());
		System.out.println("Parent Thread Inherited local "+local.get());
		Child ch=new Child();
		ch.start();
	}
}

class Child extends Thread{
	public void run() {
		System.out.println("Normal Thread local "+parent.value.get());
		System.out.println("Inherited Thread local "+parent.local.get());
	}
}

public class Q25Inheritedtl {
	public static void main(String[] args) {
		parent p=new parent();
		p.start();
	}
}

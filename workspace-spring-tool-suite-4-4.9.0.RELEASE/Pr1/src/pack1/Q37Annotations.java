package pack1;

@interface Smartphone{
	String os() default "Name";
	int version() ;
}


@FunctionalInterface
interface ab{
	void meth();
}

@Smartphone(os="haha",version=5)
class A{
    public void meth(){
        System.out.println("Meth from A");
    }
    @Deprecated
    public void m2() {
    	
    }
}

class B extends A{
    @Override
    public void meth(){
        System.out.println("Meth from B");
    }
    
}


public class Q37Annotations{

    
}
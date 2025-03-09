package pack1;
class Tests{
    long c=0;
    boolean isUpdated=false;
    public void set() throws Exception{
        while(isUpdated){
            wait();
        }
        c++;
        System.out.println("The value of c is set to "+this.c);
        isUpdated=true;
        notify();
        Thread.sleep(500);
    }
    public void get() throws Exception{
        while(!isUpdated){
            wait();
        }
        System.out.println("The value of c is "+this.c);
        isUpdated=false;
        notify();
        Thread.sleep(400);
    }
}

class Myth1 extends Thread{
    Tests t;
    Myth1(Tests t){
        this.t=t;
    }
    public void run(){
        for(int i=0;i<10;i++){
            try{
                t.set();
                Thread.sleep(200);}catch(Exception e){}
        }
    }
}

class Myth2 extends Thread{
    Tests t;
    Myth2(Tests t){
        this.t=t;
    }
    public void run(){
        for(int i=0;i<10;i++){
            try{
                t.get();
                Thread.sleep(200);}catch(Exception e){}
        }
    }
}

public class Q24WaitNotify{
    public static void main(String[] args) {
        Tests t=new Tests();
        Myth1 t1=new Myth1(t);
        Myth2 t2=new Myth2(t);
        t1.start();
        t2.start();
    }
}

package pack1;

import java.util.ArrayList;
import java.util.function.Consumer;

interface int1{
	public void printing(int n);
}

public class LambdasandStreams {
	public static void prin(int i) {
		System.out.println(i);
	}
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		int1 obj=i->System.out.print(i+" ");
		al.add(5);
		al.add(12);
		al.add(6);
		al.stream().map(x->x*2).filter(x->x%3==0).sorted().forEach(i->System.out.println(i));
		for(int i=0;i<5;i++)
			obj.printing(i);
	}
}
 
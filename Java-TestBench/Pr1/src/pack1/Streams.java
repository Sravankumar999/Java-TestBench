package pack1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Streams {
	public static void main(String[] args) {
		List<Integer> values=new ArrayList<Integer>();
		for(int i=0;i<100;i++) {
			values.add(i);
		}
		IntStream.range(0,10).filter(x->x%3==0).map(x->x+1).forEach(System.out::println);
	}
}
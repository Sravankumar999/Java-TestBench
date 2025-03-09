package pack1;

public class Threadss {
	public static void main (String[] args) {
		new Thread(
				()->{System.out.println("Running");
				}).start();
		
		
		new Thread(() -> {System.out.println("New Thread");}).start();
	}
}
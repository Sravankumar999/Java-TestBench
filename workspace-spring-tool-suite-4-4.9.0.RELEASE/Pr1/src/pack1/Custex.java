package pack1;

class CustomException extends Exception{
	private static final long serialVersionUID = 1L;

	CustomException(String s){
		super(s);
	}
}

public class Custex {
	public static void main(String[] args) {
		try {
			throw  new CustomException("This is a Custom Exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

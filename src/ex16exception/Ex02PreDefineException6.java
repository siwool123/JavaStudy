package ex16exception;

public class Ex02PreDefineException6 {

	public static void main(String[] args) {
		Object object = new Object();
		try {
			String strObject = (String)object;
		}
		catch(ClassCastException e) {
			System.out.println("형변환 할 수 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("=== ClassCastException 발생후 ===");
			
		System.out.println("끝~~~");
		
		String str = "형변환되나요?";
		if(myClassCasting(str)==true)	System.out.println("됩니다요..");
		else	System.out.println("안되네요..ㅜㅜ;");

	}
	
	public static boolean myClassCasting(Object o) {
		if(o instanceof String) return true;
		else return false;
	}

}

package ex09package.study.util;

public class CommonUtil {
/*
 * 전달된 문자열을 검사하여 숫자가 아닌 문자 포함된 경우 false를 반환하고, 모두숫자인경우 true를 반환함
 */
	public static boolean isNumber(String strValue) {
		if(strValue.length()==0) return false;
		for(int i=0; i<strValue.length(); i++) {
//codePointAt(i) : 인덱스에 해당하는 문자의 아스키코드값 반환 메소드
//문자열 전체가 숫자로만 구성되었다면 true 반환
			int acode = strValue.codePointAt(i);
			if(!(acode>='0' && acode<='9')) return false;
		}
		return true;
	}
}

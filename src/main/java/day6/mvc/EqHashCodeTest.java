package day6.mvc;

import java.util.Objects;

public class EqHashCodeTest {

	public static void main(String[] args) {

		RequestMap2 req1 = new RequestMap2("save", "GET");
		RequestMap2 req2 = new RequestMap2("save", "GET");
		
		//req1 과 req2 에 저장된 값은 객체의 참조값
		System.out.println("req1==req2 : " + (req1==req2));
		System.out.println("req1.equals(req2) : " + req1.equals(req2));
		
		//Map 은 key 값으로 value 를 찾아옵니다. url과 method 문자열이 같이면
		//		동일한 key값으로 취급되어야 합니다.
		
		RequestMap2 req3 = new RequestMap2("save", "GET");
		RequestMap2 req4 = new RequestMap2("save", "GET");
		System.out.println("req3==req4 : " + (req3==req4));
		System.out.println("req3.equals(req4) : " + req3.equals(req4));
	}

}

class RequestMap2{
	private String url;
	private String method;
	
	// 비교되는 2개의 객체가 각각 new 연산으로 만들어지면 해시코드가 다릅니다.
	@Override
	public int hashCode() {		//해시코드값 재정의 : method와 url 참조값으로 계산한 것 리턴.
		//다른 객체 other와 url과 method 문자열이 같으면 같은 해시코드값 리턴
		return Objects.hash(method, url);
	}

	@Override
	public boolean equals(Object obj) {		//obj는 현재객체와 비교되는 다른 객체
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestMap2 other = (RequestMap2) obj;
		// 다른 객체 other와 url과 method 문자열이 같으면 '참' 리턴
		return Objects.equals(method, other.method) && Objects.equals(url, other.url);
	}

	public RequestMap2(String url, String method) {
		this.url = url;
		this.method = method;
	}

	public String getMethod() {
		return method;
	}
	
	public String getUrl() {
		return url;
	}
}

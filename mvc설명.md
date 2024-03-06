주요 용어

1. MVC
2. 배포 기술자 - deployment descriptor
	ㄴ [https://cloud.google.com/appengine/docs/standard/java/config/webxml?hl=ko]
	
	웹 애플리케이션의 배포 설명자는 애플리케이션의 클래스, 리소스, 구성 및 웹 서버가 이를 사용해서 웹 요청을 처리하는 방법을 기술합니다.
	배포 설명자는 이름이 web.xml인 파일입니다. 이 파일은 앱의 WAR(설치프로그램)에서 WEB-INF/ 디렉터리에 위치하며, 루트 요소가 <web-app>인 XML 파일입니다.
	
	웹 애플리케이션이 web.xml 이 작성되어 있지않으면 톰캣에서 작성한 web.xml 이 적용됩니다.
	
3. 이 프로젝트에서는 서블릿을 1개만 만들어서 프론트 컨트롤러 역할을 합니다.
	프론트 컨트롤러는 url과 요청방식(GET 또는 POST) 에 따라 처리할 컨트롤러 객체를 생성하여
	동작하도록 합니다.
	
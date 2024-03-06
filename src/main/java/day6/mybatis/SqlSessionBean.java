package day6.mybatis;

import java.io.IOException;
import java.io.InputStream;
//Mybatis 프레임웍의 클래스들..
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionBean {

   public static SqlSessionFactory sqlSessionFactory;
   static {   //변수들이 static 영역에 저장됩니다. why: sqlSessionFactory 를 static으로 만들기 위함.
      String resource = "mybatis/mybatis-config.xml";    //mybatis 설정파일
      InputStream inputStream=null;         //파일을 읽기위한 입력 스트림
   
   
      try {
         inputStream = Resources.getResourceAsStream(resource);   //리소스 파일 자원 읽어오기
      }catch(IOException e) {
         System.out.println("mybatis 설정 파일 읽기 오류입니다.");
      }
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);   
      //실제 db연결이 성공했을 때 정상적으로 객체가 생성.
      //읽어온 파일로 factory 생성
   }
   
   //필요한 객체를 리턴
   public static SqlSessionFactory getSessionFactory() {    
      return sqlSessionFactory;
   }
}




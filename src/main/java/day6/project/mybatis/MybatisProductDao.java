package day6.project.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day6.mybatis.SqlSessionBean;
import day6.project.dto.CateDto;
import day6.project.dto.ProductDto;



public class MybatisProductDao {
	 
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();

	   
	   public List<ProductDto> selectByCategory(String c){
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<ProductDto> list = sqlSession.selectList("tblproduct.selectByCategory",c);
	      sqlSession.close();
	      return list;
	      
	   }
	 
	   public List<ProductDto> selectByPname(String c){
		   SqlSession sqlSession = sessionFactory.openSession();
		   List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname",c);
		   sqlSession.close();
		   return list;	   
	   }
	   
	   
	   public List<ProductDto> search(Map<String, Object> map) {
		   SqlSession sqlSession = sessionFactory.openSession();
		   List<ProductDto> list = sqlSession.selectList("tblproduct.search",map);
		   sqlSession.close();
		   return list;
	   }
	   
	   public List<CateDto> getCategories(){
		   SqlSession sqlSession = sessionFactory.openSession();
		   List<CateDto> list = sqlSession.selectList("tblproduct.getCategories");
		   sqlSession.close();
		   return list;
	   }
	   
   }

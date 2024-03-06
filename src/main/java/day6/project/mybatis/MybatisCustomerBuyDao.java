package day6.project.mybatis;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import day6.mybatis.SqlSessionBean;
import day6.project.dto.CustomerBuyDto;


public class MybatisCustomerBuyDao {
	  private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();

	   
	   public List<CustomerBuyDto> selectAll(){
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<CustomerBuyDto> list = sqlSession.selectList("tblcustomerbuy.selectAll");
	      return list;
	   }
	   
	   
	   public int insert(CustomerBuyDto vo) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.insert("tblcustomerbuy.insert",vo);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	      
	   }
	   
	   public int update(Map<String, Integer> map) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.update("tblcustomerbuy.update", map);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	   }
	   
	   public int delete(int customerbuyidx) {
	      SqlSession sqlSession = sessionFactory.openSession();
	      int result = sqlSession.delete("tblcustomerbuy.delete",customerbuyidx);
	      sqlSession.commit();
	      sqlSession.close();
	      return result;
	   }
	   
}

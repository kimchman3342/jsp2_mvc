package day6.project.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day6.mybatis.SqlSessionBean;
import day6.project.dto.BuyDto;
import day6.project.dto.CustomerBuyDto;






public class MybatisBuyDao {

	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisBuyDao() {
	}
	public List<BuyDto> selectAll(){
	      SqlSession sqlSession = sessionFactory.openSession();
	      List<BuyDto> list = sqlSession.selectList("tblbuy.selectAll");
	      return list;
	   }
	
 
		   public int insert(BuyDto vo) {
		      SqlSession sqlSession = sessionFactory.openSession();
		      // insert 메소드
		      int result = sqlSession.insert("tblbuy.insert",vo);
		      sqlSession.commit();
		      sqlSession.close();
		      return result;
		      
		   }
		   
		   public int update(Map<String, Integer> map) {
		      SqlSession sqlSession = sessionFactory.openSession();
		      int result = sqlSession.update("tblbuy.update", map);
		      sqlSession.commit();
		      sqlSession.close();
		      return result;
		   }
		   
		   public int delete(int buyidx) {
		      SqlSession sqlSession = sessionFactory.openSession();
		      int result = sqlSession.delete("tblbuy.delete",buyidx);
		      sqlSession.commit();
		      sqlSession.close();
		      return result;
		   }
		   
		   public List<CustomerBuyDto> selectCustomerBuyList (String cid){
			   SqlSession sqlSession = sessionFactory.openSession();
			   List<CustomerBuyDto> list = sqlSession.selectList("tblbuy.selectCustomerBuyList",cid);
			   sqlSession.close();
			   return list;
		   

	}
}

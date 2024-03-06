package day6.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day6.project.dto.BuyDto;
import day6.project.dto.CustomerBuyDto;
import day6.project.dto.CustomerDto;
import day6.project.dto.ProductDto;
import day6.project.mybatis.MybatisBuyDao;
import day6.project.mybatis.MybatisCustomerDao;
import day6.project.mybatis.MybatisProductDao;




public class MybatisSessionTest {

	public static void main(String[] args) {
	testBuy();
//	testProduct();
//	testCustomer();	
		
	}
	
	public static void testCustomer(){
		MybatisCustomerDao cusdao = new MybatisCustomerDao();
		System.out.println(" cusdao 객체 : " + cusdao);
//		System.out.println("===== join 테스트 ====="); 
//		int cusresult = cusdao.join(new CustomerDto("qudgns", "병훈","DFSQ@WFD",29,null));
//		System.out.println("반영된 행 개수 : " + cusresult);
		List<CustomerDto> cuslist = cusdao.allCustomers();
		System.out.println(cuslist);
		/*
		 * List<CustomerDto> cus_nameagelist = cusdao.allCustomers();
		 * System.out.println(cus_nameagelist);
		 */
		System.out.println("===== delete 테스트 ====="); 
		System.out.println("반영된 행 개수 : " + cusdao.delete("qudgns"));
		
		
	} 
	
		public static void testProduct() {
		MybatisProductDao prodao = new MybatisProductDao();
		System.out.println(" productdao 객체 : " + prodao);
		System.out.println("===== selectByCategory 테스트 ====="); 
		List<ProductDto> pro_catelist = prodao.selectByCategory("B2");
		System.out.println(pro_catelist);
		
		System.out.println("===== selectByPname 테스트 ====="); 
		List<ProductDto> pro_pnamelist = prodao.selectByPname("동원");
		System.out.println(pro_pnamelist);
		
	}
	
	
		
	public static void testBuy(){
		MybatisBuyDao buydao = new MybatisBuyDao();
		System.out.println(" buydao 객체 : " + buydao);
		System.out.println("===== selectAll 테스트 ====="); 
		List<BuyDto> list = buydao.selectAll();
		System.out.println(list);
		
		System.out.println("===== update 테스트 ====="); 
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("buy_Idx", 1044);
		map.put("quantity", 6);
		System.out.println(map);
		System.out.println("반영된 행 개수 : " + buydao.update(map));
		
		System.out.println("===== delete 테스트 ====="); 
		System.out.println("반영된 행 개수 : " + buydao.delete(1044));
		
		System.out.println("===== selectCustomerBuyList 테스트 ====="); 
		List<CustomerBuyDto> buylist = buydao.selectCustomerBuyList("twice");
		System.out.println(buylist);
		
		
		  System.out.println("===== insert 테스트 ====="); 
		  int buyresult = buydao.insert(new BuyDto(0, "mina012","CJBAb12g",3,null));
		  System.out.println("반영된 행 개수 : " + buyresult);
		 
		System.out.println("===== selectAll 테스트 ====="); 
		System.out.println(list);
		
	}
}
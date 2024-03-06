package day6.project.dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor		
							
@EqualsAndHashCode			// 기본생성자 : 객체 생성 후 setter로 동작하므로 컬럼명과 변수명 일치 해야 함.
public class BuyDto {
	private int buy_Idx;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buy_Date;
		
}

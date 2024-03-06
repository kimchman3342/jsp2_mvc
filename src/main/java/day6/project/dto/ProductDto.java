package day6.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor			
@EqualsAndHashCode
public class ProductDto {
	private String pcode;
	private String category;
	private String pname;
	private int price;
	
	@Override
    public String toString() {
        return String.format("%6s %15s %40s\t %,8d \n", 
                            category,pcode,pname,price);
    }
	    
}

package in.ashokit.Pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private Double productPrice;
	private Date mfDate;
	private Date expiryDate;
	private String mfBy;
	

}

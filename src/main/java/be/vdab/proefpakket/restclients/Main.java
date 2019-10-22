package be.vdab.proefpakket.restclients;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class Main {
	private BigDecimal temp; // en een getter

	public BigDecimal getTemp() {
		return temp;
	}
	
	
}
package be.vdab.proefpakket.restclients;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
class Weer {
	private Main main; // en een getter

	public Main getMain() {
		return main;
	}

}
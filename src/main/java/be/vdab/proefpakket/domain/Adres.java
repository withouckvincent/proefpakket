package be.vdab.proefpakket.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Adres implements Serializable {
private static final long serialVersionUID = 1L;
private String straat;
private String huisNr;
@ManyToOne(optional = false, fetch = FetchType.LAZY)
@JoinColumn(name = "gemeenteid")
private Gemeente gemeente;
public String getStraat() {
	return straat;
}
public String getHuisNr() {
	return huisNr;
}
public Gemeente getGemeente() {
	return gemeente;
}

// getters voor straat, huisNr en gemeente


}
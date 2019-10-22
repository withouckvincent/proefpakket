package be.vdab.proefpakket.services;

import java.util.List;

import be.vdab.proefpakket.domain.Brouwer;

public interface BrouwerService {
	List<Brouwer> findByBeginNaam(String beginNaam);
}
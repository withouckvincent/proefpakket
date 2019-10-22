package be.vdab.proefpakket.services;

import java.util.List;

import be.vdab.proefpakket.domain.Gemeente;

public interface GemeenteService {
	List<Gemeente> findAll();
}
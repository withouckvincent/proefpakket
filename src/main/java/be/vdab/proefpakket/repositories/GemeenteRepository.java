package be.vdab.proefpakket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.proefpakket.domain.Gemeente;

public interface GemeenteRepository extends JpaRepository<Gemeente, Long> {
}
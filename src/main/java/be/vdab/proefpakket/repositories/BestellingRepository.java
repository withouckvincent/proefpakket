package be.vdab.proefpakket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.proefpakket.domain.Bestelling;

public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
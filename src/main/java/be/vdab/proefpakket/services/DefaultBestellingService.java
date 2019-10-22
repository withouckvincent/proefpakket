package be.vdab.proefpakket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.proefpakket.domain.Bestelling;
import be.vdab.proefpakket.repositories.BestellingRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultBestellingService implements BestellingService {
	private final BestellingRepository bestellingRepository;

	DefaultBestellingService(BestellingRepository bestellingRepository) {
		this.bestellingRepository = bestellingRepository;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Bestelling bestelling) {
		bestellingRepository.save(bestelling);
	}
}
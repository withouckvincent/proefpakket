package be.vdab.proefpakket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.proefpakket.domain.Bestelling;
import be.vdab.proefpakket.mail.MailSender;
import be.vdab.proefpakket.repositories.BestellingRepository;

//enkele imports
@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultBestellingService implements BestellingService {
	private final BestellingRepository bestellingRepository;
	private final MailSender mailSender;

	DefaultBestellingService(BestellingRepository bestellingRepository, MailSender mailSender) {
		this.bestellingRepository = bestellingRepository;
		this.mailSender = mailSender;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Bestelling bestelling) {
		bestellingRepository.save(bestelling);
		mailSender.proefpakket(bestelling.getEmailAdres(), bestelling.getBrouwer().getNaam());
	}
}
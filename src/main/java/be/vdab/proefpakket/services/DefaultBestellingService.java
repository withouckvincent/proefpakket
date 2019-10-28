package be.vdab.proefpakket.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.proefpakket.domain.Bestelling;
import be.vdab.proefpakket.messaging.ProefpakketMessage;
import be.vdab.proefpakket.repositories.BestellingRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
class DefaultBestellingService implements BestellingService {
	private final BestellingRepository bestellingRepository;
	private final JmsTemplate jmsTemplate;
	private final String proefpakketQueue;

	DefaultBestellingService(BestellingRepository bestellingRepository, JmsTemplate jmsTemplate,
			@Value("${proefpakketQueue}") String proefpakketQueue) {
		this.bestellingRepository = bestellingRepository;
		this.jmsTemplate = jmsTemplate;
		this.proefpakketQueue = proefpakketQueue;
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void create(Bestelling bestelling) {
		bestellingRepository.save(bestelling);
		ProefpakketMessage message = new ProefpakketMessage(bestelling.getEmailAdres(),
				bestelling.getBrouwer().getNaam());
		jmsTemplate.convertAndSend(proefpakketQueue, message);
	}
}

package be.vdab.proefpakket.controllers;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.proefpakket.domain.Brouwer;

@Component
@RequestMapping("brouwers")
class BrouwerController {
	private static final String VIEW = "brouwers/brouwer";
	private static final String REDIRECT_BIJ_BROUWER_NIET_GEVONDEN = "redirect:/";

	@GetMapping("{optionalBrouwer}")
	public ModelAndView read(@PathVariable Optional<Brouwer> optionalBrouwer) {
		ModelAndView modelAndView = new ModelAndView("brouwer");
		optionalBrouwer.ifPresent(brouwer -> modelAndView.addObject(brouwer));
		return modelAndView;
	}
}
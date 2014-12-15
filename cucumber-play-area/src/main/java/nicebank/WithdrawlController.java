package nicebank;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WithdrawlController {

	
	@RequestMapping(value="/withdraw", method = RequestMethod.POST)
	public ModelAndView withdraw(String amount) {
		return new ModelAndView("withdrawlresponse").addObject("amount", amount);
	}
}

package no.nith.sivpal12.futurama.quotes.controllers;

import java.util.Date;

import javax.annotation.Resource;

import no.nith.sivpal12.futurama.quotes.db.objects.Quote;
import no.nith.sivpal12.futurama.quotes.services.TestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Resource
    private TestService testService;

    @RequestMapping()
    public ModelAndView hello() {
        Quote quote = new Quote();
        quote.setQuote(new Date().toString());
        testService.save(quote);
        return new ModelAndView("helloWorld");
    }

}

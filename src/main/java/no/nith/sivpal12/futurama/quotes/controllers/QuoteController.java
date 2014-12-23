package no.nith.sivpal12.futurama.quotes.controllers;

import java.util.List;

import javax.annotation.Resource;

import no.nith.sivpal12.futurama.quotes.constants.UriContext;
import no.nith.sivpal12.futurama.quotes.constants.ViewName;
import no.nith.sivpal12.futurama.quotes.entities.Quote;
import no.nith.sivpal12.futurama.quotes.services.QuoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(UriContext.QUOTE)
public class QuoteController {

    @Resource
    private QuoteService quoteService;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(Quote quote) {
        quoteService.save(quote);
        return get();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {
        List<Quote> quotes = quoteService.getAll();
        System.out.println(quotes);
        return new ModelAndView(ViewName.QUOTE_QUOTES)
                .addObject(new Quote())
                .addObject("quotes", quotes);
    }
}

package no.nith.sivpal12.futurama.quotes.services;

import java.util.List;

import no.nith.sivpal12.futurama.quotes.entities.Quote;
import no.nith.sivpal12.futurama.quotes.repositories.QuoteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepo quoteRepo;

    public void save(Quote quote) {
        quoteRepo.save(quote);
    }

    public List<Quote> getAll() {
        return quoteRepo.all();
    }
}

package no.nith.sivpal12.futurama.quotes.services;

import no.nith.sivpal12.futurama.quotes.db.objects.Quote;
import no.nith.sivpal12.futurama.quotes.repositorys.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private Repo repo;

    public void save(Quote quote) {
        repo.save(quote);
    }

}

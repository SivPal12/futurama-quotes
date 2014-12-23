package no.nith.sivpal12.futurama.quotes.repositories;

import java.util.List;

import no.nith.sivpal12.futurama.quotes.entities.Quote;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuoteRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Quote quote) {
        sessionFactory.getCurrentSession()
                .save(quote);
    }

    @Transactional
    public List<Quote> all() {
        return sessionFactory.getCurrentSession().createCriteria(Quote.class)
                .list();
    }

}

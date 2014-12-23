package no.nith.sivpal12.futurama.quotes.repositories;

import no.nith.sivpal12.futurama.quotes.entities.Quote;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Repo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
}

    public void save(Quote quote) {
        getCurrentSession().save(quote);
    }

    public String getQuote() {
        return ((Quote) sessionFactory.getCurrentSession().get(Quote.class, 1))
                .getQuote();
    }
}
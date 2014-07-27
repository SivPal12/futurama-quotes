package no.nith.sivpal12.futurama.quotes.repositorys;

import no.nith.sivpal12.futurama.quotes.db.objects.Quote;

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
}
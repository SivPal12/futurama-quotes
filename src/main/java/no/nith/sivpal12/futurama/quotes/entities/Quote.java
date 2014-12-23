package no.nith.sivpal12.futurama.quotes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quote;

    public String getQuote() {
        return quote;
    }

    public Quote setQuote(String quote) {
        this.quote = quote;
        return this;
    }
}

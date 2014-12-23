package no.nith.sivpal12.futurama.quotes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Quote {
    @Id
    @Generated(GenerationTime.INSERT)
    private int id;
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

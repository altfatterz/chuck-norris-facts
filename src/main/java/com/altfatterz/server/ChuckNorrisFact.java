package com.altfatterz.server;

import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "chuck_norris_facts")
class ChuckNorrisFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    // for JPA to work
    protected ChuckNorrisFact() {
    }

    public ChuckNorrisFact(String text) {
        Assert.notNull(text);
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChuckNorrisFact that = (ChuckNorrisFact) o;

        return text.equals(that.text);

    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}

package com.lrosa.rastreamento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tail {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String clientIdentifier;

    private String page;

    private Date dateAccess;

    public Tail() {

    }

    public Tail(final String clientIdentifier, final String page, final Date dateAccess) {
        this.clientIdentifier = clientIdentifier;
        this.page = page;
        this.dateAccess = dateAccess;
    }


    public Long getId() {
        return id;
    }


    public void setId(final Long id) {
        this.id = id;
    }


    public String getClientIdentifier() {
        return clientIdentifier;
    }


    public void setClientIdentifier(final String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }


    public String getPage() {
        return page;
    }


    public void setPage(final String page) {
        this.page = page;
    }

	public Date getDateAccess() {
		return dateAccess;
	}

	public void setDateAccess(Date dateAccess) {
		this.dateAccess = dateAccess;
	}



}

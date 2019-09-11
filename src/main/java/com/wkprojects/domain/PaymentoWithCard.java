package com.wkprojects.domain;

import javax.persistence.Entity;

import com.wkprojects.domain.enums.PaymentStatus;

@Entity
public class PaymentoWithCard extends Payment {

	private static final long serialVersionUID = 1L;

	private Integer numberOfPlots;

	public PaymentoWithCard() {
	}

	public PaymentoWithCard(Integer id, PaymentStatus status, Demand demand, Integer numberOfPlots) {
		super(id, status, demand);
		this.numberOfPlots = numberOfPlots;
	}

	public Integer getNumberOfPlots() {
		return numberOfPlots;
	}

	public void setNumberOfPlots(Integer numberOfPlots) {
		this.numberOfPlots = numberOfPlots;
	}

}

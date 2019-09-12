package com.wkprojects.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wkprojects.domain.enums.PaymentStatus;

@Entity
public class PaymentWithTicket extends Payment {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;

	public PaymentWithTicket() {
	}

	public PaymentWithTicket(Integer id, PaymentStatus status, Demand demand, Date dueDate, Date paymentoDate) {
		super(id, status, demand);
		this.dueDate = dueDate;
		this.paymentDate = paymentoDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}

package com.wkprojects.domain.enums;

public enum PaymentStatus {
	PENDING(1, "Pendente"),
	SETTLED(2, "Quitado"),
	CANCELED(3, "Cancelado");
	
	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null)
			return null;

		for (PaymentStatus paymentStatus : PaymentStatus.values()) {
			if (cod.equals(paymentStatus.cod))
				return paymentStatus;
		}
		
		throw new IllegalArgumentException("Invalid cod" + cod);
	}
}

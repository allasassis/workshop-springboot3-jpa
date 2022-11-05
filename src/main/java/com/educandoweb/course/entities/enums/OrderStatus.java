package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	// aqui ele vai percorrer todos os valores, e se o valor for igual ao valor passado, ele retornará
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code!");
	}
	
	// aqui nós numeramos os status, para evitar problemas de manutenção no futuro, se algum dia for adicionado um novo status, ali mudaria e conflitaria
	// no banco de dados
}

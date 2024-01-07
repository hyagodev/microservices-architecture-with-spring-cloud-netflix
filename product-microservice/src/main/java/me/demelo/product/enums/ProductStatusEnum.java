package me.demelo.product.enums;

import me.demelo.base.enums.IEnum;

public enum ProductStatusEnum implements IEnum<String> {
	ACTIVE("A", "Ativo"),
	INACTIVE("I", "Inativo");

	private String code;
	private String description;
	
	ProductStatusEnum(String code, String description){
		this.code = code;
		this.description = description;
	}
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDescription() {
		return description;
	}

}

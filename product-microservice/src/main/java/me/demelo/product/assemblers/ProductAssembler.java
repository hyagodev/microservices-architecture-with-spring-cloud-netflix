package me.demelo.product.assemblers;


import org.springframework.stereotype.Component;

import me.demelo.base.assemblers.IAssembler;
import me.demelo.base.utils.ObjectUtils;
import me.demelo.product.models.Product;

@Component
public class ProductAssembler implements IAssembler<Product> {

	@Override
	public void apply(Product source, Product target) {
		target.setName(ObjectUtils.defaultIfNull(source.getName(), target.getName()));
		target.setDescription(ObjectUtils.defaultIfNull(source.getDescription(), target.getDescription()));
		target.setPrice(ObjectUtils.defaultIfNull(source.getPrice(), target.getPrice()));
	}

}

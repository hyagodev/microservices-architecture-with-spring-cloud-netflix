package me.demelo.product.services;

import org.springframework.stereotype.Service;

import me.demelo.base.services.AbstractService;
import me.demelo.product.enums.ProductStatusEnum;
import me.demelo.product.models.Product;

@Service
public class ProductService extends AbstractService<Product, Long, ProductStatusEnum> {

}

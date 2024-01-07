package me.demelo.product.controllers;

import org.springframework.web.bind.annotation.RestController;

import me.demelo.base.controllers.AbstractController;
import me.demelo.product.dtos.request.CreateProductRequestDTO;
import me.demelo.product.dtos.request.UpdateProductRequestDTO;
import me.demelo.product.dtos.response.CreateProductResponseDTO;
import me.demelo.product.dtos.response.DetailProductResponseDTO;
import me.demelo.product.dtos.response.SimpleProductResponseDTO;
import me.demelo.product.enums.ProductStatusEnum;
import me.demelo.product.models.Product;

@RestController("/products")
public class ProductController extends
		AbstractController<Product, Long, ProductStatusEnum, SimpleProductResponseDTO, DetailProductResponseDTO, CreateProductRequestDTO, CreateProductResponseDTO, UpdateProductRequestDTO> {

}

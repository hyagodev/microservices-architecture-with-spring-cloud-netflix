package me.demelo.product.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.demelo.base.converters.IConverter;
import me.demelo.product.dtos.request.CreateProductRequestDTO;
import me.demelo.product.dtos.request.UpdateProductRequestDTO;
import me.demelo.product.dtos.response.CreateProductResponseDTO;
import me.demelo.product.dtos.response.DetailProductResponseDTO;
import me.demelo.product.dtos.response.SimpleProductResponseDTO;
import me.demelo.product.models.Product;

@Component
public class ProductConverter implements
		IConverter<Product, SimpleProductResponseDTO, DetailProductResponseDTO, CreateProductRequestDTO, CreateProductResponseDTO, UpdateProductRequestDTO> {

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public SimpleProductResponseDTO convertToSimpleResponse(Product model) {
		return mapper.map(model, SimpleProductResponseDTO.class);
	}

	@Override
	public DetailProductResponseDTO convertToDetailResponse(Product model) {
		return mapper.map(model, DetailProductResponseDTO.class);
	}

	@Override
	public CreateProductResponseDTO convertToCreateResponse(Product model) {
		return mapper.map(model, CreateProductResponseDTO.class);
	}

	@Override
	public Product convertFromCreateRequest(CreateProductRequestDTO request) {
		return mapper.map(request, Product.class);
	}

	@Override
	public Product convertFromUpdateRequest(UpdateProductRequestDTO request) {
		return mapper.map(request, Product.class);
	}

}

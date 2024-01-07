package me.demelo.product.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.demelo.base.dtos.AbstractDTO;
import me.demelo.product.enums.ProductStatusEnum;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SimpleProductResponseDTO extends AbstractDTO<Long, ProductStatusEnum> {
	
	private String name;
	private Double price;
}

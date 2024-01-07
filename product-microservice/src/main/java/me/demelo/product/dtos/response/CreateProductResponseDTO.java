package me.demelo.product.dtos.response;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.demelo.base.dtos.AbstractDTO;
import me.demelo.product.enums.ProductStatusEnum;

@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class CreateProductResponseDTO extends AbstractDTO<Long, ProductStatusEnum> {
}

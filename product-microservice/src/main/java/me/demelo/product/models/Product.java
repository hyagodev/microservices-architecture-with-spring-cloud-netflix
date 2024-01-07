package me.demelo.product.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.demelo.base.models.AbstractModel;
import me.demelo.product.enums.ProductStatusEnum;

@Entity(name = "product")
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractModel<Long, ProductStatusEnum> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Double price;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public ProductStatusEnum getInitialStatus() {
		return ProductStatusEnum.ACTIVE;
	}

	@Override
	protected ProductStatusEnum getDeletedStatus() {
		return ProductStatusEnum.INACTIVE;
	}
}

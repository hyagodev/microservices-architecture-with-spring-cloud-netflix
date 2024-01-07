package me.demelo.base.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import me.demelo.base.enums.IEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AbstractDTO<ID, STATUS extends IEnum<?>> {

	private ID id;
	private STATUS status;
}

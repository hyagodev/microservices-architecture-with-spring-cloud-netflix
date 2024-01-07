package me.demelo.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import me.demelo.base.converters.IConverter;
import me.demelo.base.enums.IEnum;
import me.demelo.base.models.AbstractModel;
import me.demelo.base.services.AbstractService;

public class AbstractController<T extends AbstractModel<ID, STATUS>, ID, STATUS extends IEnum<?>, SRES, DRES, CREQ,CRES,UREQ> {

	@Autowired
	private AbstractService<T, ID, STATUS> service;
	
	@Autowired
	private IConverter<T, SRES, DRES, CREQ, CRES, UREQ> converter;
	
	@GetMapping
	public ResponseEntity<Page<SRES>> find(Pageable pageable){
		return ResponseEntity.ok(service.find(pageable).map(r -> converter.convertToSimpleResponse(r)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DRES> findById(@PathVariable ID id) {
		return ResponseEntity.ok(converter.convertToDetailResponse(service.findById(id)));
	}
	
	@PostMapping
	public ResponseEntity<CRES> create(@RequestBody CREQ request) {
		var model = converter.convertFromCreateRequest(request);
		model = service.create(model);
		//TODO adicionar URI
		return ResponseEntity.created(null).body(converter.convertToCreateResponse(model));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable ID id, @RequestBody UREQ request) {
		service.update(id, converter.convertFromUpdateRequest(request));
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable ID id) {
		service.delete(id);
	}
}

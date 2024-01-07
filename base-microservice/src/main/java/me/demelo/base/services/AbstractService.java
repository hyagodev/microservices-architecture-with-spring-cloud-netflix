package me.demelo.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.transaction.Transactional;
import me.demelo.base.assemblers.IAssembler;
import me.demelo.base.enums.IEnum;
import me.demelo.base.exceptions.ResourceNotFoundException;
import me.demelo.base.models.AbstractModel;
import me.demelo.base.repositories.AbstractRepository;

public class AbstractService<T extends AbstractModel<ID, STATUS>, ID, STATUS extends IEnum<?>> {

	@Autowired
	private AbstractRepository<T, ID> repository;
	
	@Autowired
	private IAssembler<T> assembler;
	
	public Page<T> find(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	public T findById(ID id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
	}
	
	@Transactional
	public T create(T model) {
		return repository.save(model);
	}
	
	@Transactional
	public T update(ID id, T model) {
		var persistentModel = findById(id);
		assembler.apply(model, persistentModel);
		return repository.save(persistentModel);
	}
	
	@Transactional
	public void delete(ID id) {
		var persistentModel = findById(id);
		persistentModel.setDeletedStatus();
		repository.save(persistentModel);
	}
}

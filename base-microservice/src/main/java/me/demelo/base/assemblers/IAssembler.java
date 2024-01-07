package me.demelo.base.assemblers;

public interface IAssembler<T> {

	void apply(T source, T target);
}

package me.demelo.base.converters;

public interface IConverter<T, SRES, DRES, CREQ, CRES, UREQ> {

	SRES convertToSimpleResponse(T model);
	DRES convertToDetailResponse(T model);
	CRES convertToCreateResponse(T model);
	
	T convertFromCreateRequest(CREQ request);
	T convertFromUpdateRequest(UREQ request);
}

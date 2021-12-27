package com.spring.security.mapping;


public interface IMapping<T, D> {

	D toDTO(T t);

	T toEntity(D d);
	

}

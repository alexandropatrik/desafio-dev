package com.bycoders.cnabdemo.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;
import org.springframework.data.domain.Page;

public class ModelMapperUtils {

	
    public static <D, T> Page<D> mapEntityPageIntoDtoPage(ModelMapper modelMapper, Page<T> entities, Class<D> dtoClass) {
    	modelMapper.getConfiguration().setFieldMatchingEnabled(true)
	    	.setFieldAccessLevel(AccessLevel.PRIVATE)
	    	.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
    } 
    
    public static <S, T> List<T> mapList(ModelMapper modelMapper, List<S> source, Class<T> targetClass) {
        return source
          .stream()
          .map(element -> modelMapper.map(element, targetClass))
          .collect(Collectors.toList());
    }
}

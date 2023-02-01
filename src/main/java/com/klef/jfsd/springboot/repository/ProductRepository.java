package com.klef.jfsd.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
{

}

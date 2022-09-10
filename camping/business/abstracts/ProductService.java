package com.example.camping.business.abstracts;

import com.example.camping.core.utilities.results.DataResult;
import com.example.camping.core.utilities.results.Result;
import com.example.camping.entity.concretes.Products;
import lombok.Data;

import java.util.List;
//Service,Controllers'ın kullanacağı operasyonları içerir.
//Burda da bu operasyonların en olacağını belirlemek için interface.

public interface ProductService {

    DataResult<List<Products>> getAll();
    Result add(Products products);
    DataResult<Products> getByProductName(String productName);
    DataResult<Products> getById(int id);
    DataResult<Products> getByProductNameAndId(String productName,int id);


}

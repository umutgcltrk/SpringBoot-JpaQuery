package com.example.camping.api.controllers;

import com.example.camping.business.abstracts.ProductService;
import com.example.camping.core.utilities.results.DataResult;
import com.example.camping.core.utilities.results.Result;
import com.example.camping.core.utilities.results.SuccessResult;
import com.example.camping.entity.concretes.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Products>> getAll(){
        return this.productService.getAll();
    }
    @PostMapping("/add-product")
    public Result addProduct(@RequestBody Products products){
        this.productService.add(products);
        return new SuccessResult("Product eklendi");
    }
    @GetMapping("/getByProductName")
    public DataResult<Products> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductId")
    public DataResult<Products> getByProductId(@RequestParam int id){
        return this.productService.getById(id);
    }
    @GetMapping("/getByProductNameAndId")
    public DataResult<Products> getByProductNameAndId(@RequestParam String productName,int id){
        return this.productService.getByProductNameAndId(productName,id);
    }

}

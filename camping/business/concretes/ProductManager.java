package com.example.camping.business.concretes;

import com.example.camping.business.abstracts.ProductService;
import com.example.camping.core.utilities.results.DataResult;
import com.example.camping.core.utilities.results.Result;
import com.example.camping.core.utilities.results.SuccessDataResult;
import com.example.camping.core.utilities.results.SuccessResult;
import com.example.camping.dataAccess.abstracts.ProductDao;
import com.example.camping.entity.concretes.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Service,Controllers'ın kullanacağı operasyonları içerir.
//ProductService interfacesi doldurulur.
@Service
public class ProductManager implements ProductService {
    //ProductDao veriye erişmek için burada çağırılıyor.
    private ProductDao productDao;

    //Burda da eriştiğimiz nesnenin verisi için dependency injection yöntemi kullanılıyor.(Constructor Inject)
    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Products>> getAll() {
        return new SuccessDataResult<List<Products>>
                (this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Products products) {
        this.productDao.save(products);
        return new SuccessResult("Veri eklendi");
    }

    @Override
    public DataResult<Products> getByProductName(String productName) {
        return new SuccessDataResult<Products>
                (this.productDao.getByProductName(productName),productName+" isimde data getirildi.");
    }

    @Override
    public DataResult<Products> getById(int id) {
        return new SuccessDataResult<Products>
                (this.productDao.getById(id),id+" bu id getirildi.");
    }

    @Override
    public DataResult<Products> getByProductNameAndId(String productName, int id) {
        return new SuccessDataResult<Products>
                (this.productDao.getByProductNameAndAndId(productName,id),productName+" bu isimdeki ürün ve ,"+id+" bu Id'deki ürün getirildi.");
    }


}

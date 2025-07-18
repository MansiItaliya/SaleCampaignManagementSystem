package com.project5.Campaign.Controller;

import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Dtos.GetProductDto;
import com.project5.Campaign.Dtos.ProductResponceDto;
import com.project5.Campaign.Model.Product;
import com.project5.Campaign.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired private ProductService productService;

    @PostMapping("save-product")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody List<Product> product){
        productService.saveProduct(product);
        return new ResponseEntity<>(MessageCons.SAVED_PRODUCT, HttpStatus.CREATED);
    }

    @GetMapping("get-product-by-id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping("pagination-products")
    public ResponseEntity<ProductResponceDto> paginationProducts(@RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int pageSize){
        return ResponseEntity.ok(productService.paginationProducts(page,pageSize));
    }

    @GetMapping("get-product-by-sorting-field")
    public ResponseEntity<ProductResponceDto> getProductWithPaginationAndSortingField(@RequestParam(defaultValue = "0")int page,
                                                                                      @RequestParam(defaultValue = "10")int pageSize,
                                                                                      @RequestParam String name){
        return ResponseEntity.ok(productService.getProductWithPaginationAndSorting(page,pageSize,name));
    }

    @GetMapping("get-products")
    public ResponseEntity<List<GetProductDto>> getAllProductsWithSalePrice(){
        return ResponseEntity.ok(productService.getAllProductsWithSalePrice());
    }
}

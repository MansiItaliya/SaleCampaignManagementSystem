package com.project5.Campaign.Service;

import com.project5.Campaign.Constant.ErrorCons;
import com.project5.Campaign.Constant.MessageCons;
import com.project5.Campaign.Dtos.GetProductDto;
import com.project5.Campaign.Dtos.ProductResponceDto;
import com.project5.Campaign.Model.Product;
import com.project5.Campaign.Repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired private ProductRepo productRepo;
    @Autowired private ModelMapper modelMapper;

    public void saveProduct(List<Product> product){
        productRepo.saveAll(product);
        logger.info(MessageCons.SAVED_PRODUCT);
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElseThrow(()->{
                    logger.error(ErrorCons.PRODUCT_NOT_FOUND);
                    return new NoSuchElementException(ErrorCons.PRODUCT_NOT_FOUND);
                });
    }

    //get all product with pagination
    public ProductResponceDto paginationProducts(int page, int pageSize){
        if (page < 0 || pageSize < 0) {
            logger.error(ErrorCons.INVALID_INPUT);
            throw new IllegalArgumentException(ErrorCons.INVALID_INPUT);
        }
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepo.findAll(pageable);
        List<ProductResponceDto.products> productsList = getProductsList(productPage);

        return new ProductResponceDto(productPage.getNumber(), productPage.getSize(), productPage.getTotalPages(), productPage.getTotalElements(), productPage.isLast(), productsList);
    }

    //get all product with pagination by productName descending order
    public ProductResponceDto getProductWithPaginationAndSorting(int page,int pageSize,String name){
        Pageable pageable = PageRequest.of(page,pageSize, Sort.by(Sort.Direction.DESC,name));
        Page<Product> productPage = productRepo.findAll(pageable);
        List<ProductResponceDto.products> productsList = getProductsList(productPage);

        return new ProductResponceDto(productPage.getNumber(),productPage.getSize(),productPage.getTotalPages(),productPage.getTotalElements(),productPage.isLast(),productsList);
    }

    private List<ProductResponceDto.products> getProductsList(Page<Product> productPage) {
        if (productPage.isEmpty()) {
            logger.warn(ErrorCons.PRODUCT_PAGE_EMPTY);
            logger.error(ErrorCons.PRODUCT_NOT_FOUND);
            throw new NoSuchElementException(ErrorCons.PRODUCT_NOT_FOUND);
        }

        return productPage.getContent().stream()
                .map(products -> modelMapper.map(products,ProductResponceDto.products.class))
                .collect(Collectors.toList());
    }

    public List<GetProductDto> getAllProductsWithSalePrice(){
        List<Product> list = productRepo.findAll();
        if (list.isEmpty()){
            logger.error(ErrorCons.PRODUCT_NOT_FOUND);
            throw new NoSuchElementException(ErrorCons.PRODUCT_NOT_FOUND);
        }

        //using lambda expression
        return list.stream()
                .map(product -> modelMapper.map(product,GetProductDto.class))
                .collect(Collectors.toList());

        //without lambda
//        List<GetProductDto> getProductDtoList = new ArrayList<>();
//        for (Product product : list) {
//
//            GetProductDto getProductDto = modelMapper.map(product,GetProductDto.class);
//            getProductDtoList.add(getProductDto);
//        }
//        return getProductDtoList;
    }
}

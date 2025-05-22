package com.friend.farmers.service;


import com.ecommerce.flipkart.payload.ProductDTO;
import com.ecommerce.flipkart.payload.ProductResponse;

public interface ProductService {

    ProductDTO addProduct(Long categoryId,ProductDTO productDTO);

    ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductResponse searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductResponse searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductDTO updateProduct(Long productId, ProductDTO productDTO);

    ProductDTO deleteProduct(Long productId);

//    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}

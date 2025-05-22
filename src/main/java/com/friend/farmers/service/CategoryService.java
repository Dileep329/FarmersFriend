package com.friend.farmers.service;

import com.ecommerce.flipkart.payload.CategoryDTO;
import com.ecommerce.flipkart.payload.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {

     CategoryResponse getAllUser(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);

     CategoryDTO saveCategory(CategoryDTO categoryDTO);

     CategoryDTO deleteCategory(Long categoryId);

     CategoryDTO updateCategory(@Valid CategoryDTO categoryDTO, Long categoryId);
}

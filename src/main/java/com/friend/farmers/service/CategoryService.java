package com.friend.farmers.service;

import com.friend.farmers.payload.CategoryDTO;
import com.friend.farmers.payload.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {

     CategoryResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

     CategoryDTO saveCategory(CategoryDTO categoryDTO);

     CategoryDTO deleteCategory(Long categoryId);

     CategoryDTO updateCategory(@Valid CategoryDTO categoryDTO, Long categoryId);
}

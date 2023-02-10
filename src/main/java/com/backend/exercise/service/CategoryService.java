package com.backend.exercise.service;

import com.backend.exercise.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    List<Category> getAllCategories();
}

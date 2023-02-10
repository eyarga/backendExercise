package com.backend.exercise.serviceImpl;

import com.backend.exercise.model.Category;
import com.backend.exercise.model.Post;
import com.backend.exercise.repository.CategoryRepository;
import com.backend.exercise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private List<String> categoriesList = List.of("General", "Technology", "Random");

    @Override
    public List<Category> getAllCategories() {
        loadCategories(categoriesList);
        return categoryRepository.findAll();
    }

    private void loadCategories(List<String> categoriesList ) {

        List<Category> listFromDb = categoryRepository.findAll();
        if(listFromDb.isEmpty()) {
            List<Category> categories = categoriesList.stream().map(category -> {
                Category categoryToAdd = new Category();
                categoryToAdd.setName(category);
                return categoryToAdd;
            }).collect(Collectors.toList());
            categoryRepository.saveAll(categories);
        }
    }
}

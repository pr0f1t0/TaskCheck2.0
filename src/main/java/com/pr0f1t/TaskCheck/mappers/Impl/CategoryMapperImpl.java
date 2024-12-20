package com.pr0f1t.TaskCheck.mappers.Impl;

import com.pr0f1t.TaskCheck.domain.dto.CategoryDto;
import com.pr0f1t.TaskCheck.domain.entity.Category;
import com.pr0f1t.TaskCheck.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class CategoryMapperImpl implements Mapper<Category, CategoryDto> {

    private ModelMapper modelMapper;

    @Override
    public CategoryDto mapTo(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category mapFrom(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}

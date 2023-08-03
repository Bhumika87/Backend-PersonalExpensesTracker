package com.finance.Personalfinance.Service;

import com.finance.Personalfinance.Dto.CategoryDto;
import com.finance.Personalfinance.Model.Category;
import com.finance.Personalfinance.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;
    @Autowired
    private ModelMapper modelMapper;


    public CategoryDto addCategory(CategoryDto categoryDto){
        //category dto ko entity m change krna hai fir database m save krna hai
       Category cat = this.modelMapper.map(categoryDto,Category.class);
        Category sav = this.repo.save(cat);
        return this.modelMapper.map(sav,CategoryDto.class);
    }
    public List<CategoryDto> viewAll(){
        List<Category> getall =this.repo.findAll();
        List<CategoryDto> catLi= getall.stream().map(category -> this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return catLi;

    }
}

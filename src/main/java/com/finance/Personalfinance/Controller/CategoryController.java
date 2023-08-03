package com.finance.Personalfinance.Controller;

import com.finance.Personalfinance.Dto.CategoryDto;
import com.finance.Personalfinance.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    private CategoryDto categoryDto;
    @PostMapping("/addCat")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto create=this.categoryService.addCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(create, HttpStatus.ACCEPTED);
    }
    @GetMapping("view")
    public ResponseEntity<List<CategoryDto>> viewAllCategory()
    {
        List<CategoryDto>record=categoryService.viewAll();
        return new ResponseEntity<>(record,HttpStatus.ACCEPTED);
    }
}

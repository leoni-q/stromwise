package com.stromwise.skilltree.category;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Get all category names")
    @GetMapping("/names")
    public ResponseEntity<GetCategoriesResponse> getAllNames() {
        Set<String> names = categoryService.getAllNames();
        return new ResponseEntity<>(new GetCategoriesResponse(names), HttpStatus.OK);
    }

    @ApiOperation(value = "Get most popular category names")
    @GetMapping("/names/most-popular")
    public ResponseEntity<GetCategoriesResponse> getMostPopularNames() {
        Set<String> names = categoryService.getMostPopularNames();
        return new ResponseEntity<>(new GetCategoriesResponse(names), HttpStatus.OK);
    }
}

package com.project.moonbuddy.product;


import com.project.moonbuddy.board.dto.response.BoardResponse;
import com.project.moonbuddy.product.dto.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/product")

public class ProductController {
    private final ProductService productService;
    private HttpSession httpSession;;
    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<ProductResponse> productList=productService.selectAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }
    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Long id){
        ProductResponse productResponse = productService.select(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

}

package com.project.moonbuddy.product;


import com.project.moonbuddy.board.dto.response.BoardResponse;
import com.project.moonbuddy.product.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "select products", description = "상품 전체 조회하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    })
    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        List<ProductResponse> productList=productService.selectAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @Operation(summary = "select product", description = "상품 하나 조회하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    })
    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Long id){
        ProductResponse productResponse = productService.select(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

}

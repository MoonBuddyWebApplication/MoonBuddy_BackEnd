package com.project.moonbuddy.product;


import com.project.moonbuddy.product.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping("/post")
    public ResponseEntity post(@RequestBody ReviewDTO.Request request){
        String status= reviewService.post(request);
        return ResponseEntity.status(HttpStatus.OK).body(status);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        String status = reviewService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
}

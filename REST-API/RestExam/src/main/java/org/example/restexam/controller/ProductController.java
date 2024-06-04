package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final Map<Long, Product> products = new HashMap<>();
    private Long id = 0L;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        id += 1;
        product.setId(id);
        products.put(id, product);
        return product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id){
        Product product = products.get(id);

        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 id에 해당하는 Product가 없습니다");
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = products.values().stream().toList();
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        Product product = products.get(id);

        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 id에 해당하는 Product가 없습니다.");
        } else {
            updatedProduct.setId(id); // 테스트코드에서 id를 넘기지 않았기 때문에, id 설정해줘야 함!! 안그러면 에러 남..
            products.put(id, updatedProduct);
            return ResponseEntity.ok(updatedProduct);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        Product removedProduct = products.remove(id);

        if (removedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 id에 해당하는 Product가 없습니다.");
        } else {
            return ResponseEntity.ok(id + "번 Product 삭제가 완료되었습니다.");
        }
    }

}

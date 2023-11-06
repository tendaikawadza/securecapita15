package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.Stock;
import io.getarrays.securecapita.repository.StockRepository;
import io.getarrays.securecapita.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stock")
@RequiredArgsConstructor
public class StockResource {


    // Assume ProductService class handles product inventory
    @Autowired
    private StockService stockService;



    @PostMapping("/add")
    public ResponseEntity<Stock> createProduct(@RequestBody Stock stock){

        Stock createStock =  stockService.createStock(stock);
        return new ResponseEntity<>(createStock, HttpStatus.OK);
    }

    @GetMapping("/totalQuantity")
    public int getTotalQuantityByProductCode(@RequestParam String productCode) {
        return stockService.getTotalQuantityByProductCode(productCode);
    }

}

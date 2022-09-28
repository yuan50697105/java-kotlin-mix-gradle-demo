package com.example.demo.controller;

import com.example.demo.entity.JavaGoodsStock;
import com.example.demo.entity.dto.JavaGoodsStockAddDTO;
import com.example.demo.entity.dto.JavaGoodsStockUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsStockWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaGoodsStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/goods/stock")
public class JavaGoodsStockController {
    private final JavaGoodsStockService service;

    @Autowired
    public JavaGoodsStockController(JavaGoodsStockService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaGoodsStockAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaGoodsStockAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaGoodsStockUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaGoodsStockUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaGoodsStock get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaGoodsStock> get(JavaGoodsStockWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}")
    public Pagination<JavaGoodsStock> get(JavaGoodsStockWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }
}

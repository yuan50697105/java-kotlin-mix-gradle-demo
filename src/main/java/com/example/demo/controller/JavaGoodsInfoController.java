package com.example.demo.controller;

import com.example.demo.entity.JavaGoodsInfo;
import com.example.demo.entity.dto.JavaGoodsInfoAddDTO;
import com.example.demo.entity.dto.JavaGoodsInfoUpdateDTO;
import com.example.demo.entity.dto.JavaGoodsInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/goods/info")
public class JavaGoodsInfoController {
    private final JavaGoodsInfoService service;

    @Autowired
    public JavaGoodsInfoController(JavaGoodsInfoService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaGoodsInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaGoodsInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaGoodsInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaGoodsInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaGoodsInfo get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaGoodsInfo> get(JavaGoodsInfoWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}/list")
    public Pagination<JavaGoodsInfo> get(JavaGoodsInfoWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }
}

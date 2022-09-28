package com.example.demo.controller;

import com.example.demo.entity.JavaOrderInfo;
import com.example.demo.entity.dto.JavaOrderInfoAddDTO;
import com.example.demo.entity.dto.JavaOrderInfoUpdateDTO;
import com.example.demo.entity.dto.JavaOrderInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/order/info")
public class JavaOrderInfoController {
    private final JavaOrderInfoService service;

    @Autowired
    public JavaOrderInfoController(JavaOrderInfoService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaOrderInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaOrderInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaOrderInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaOrderInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaOrderInfo get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaOrderInfo> get(JavaOrderInfoWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}")
    public Pagination<JavaOrderInfo> get(JavaOrderInfoWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }
}

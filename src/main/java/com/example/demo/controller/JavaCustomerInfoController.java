package com.example.demo.controller;

import com.example.demo.entity.JavaCustomerInfo;
import com.example.demo.entity.dto.JavaCustomerInfoAddDTO;
import com.example.demo.entity.dto.JavaCustomerInfoUpdateDTO;
import com.example.demo.entity.dto.JavaCustomerInfoWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaCustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/customer/info")
public class JavaCustomerInfoController {
    private final JavaCustomerInfoService service;

    @Autowired
    public JavaCustomerInfoController(JavaCustomerInfoService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaCustomerInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaCustomerInfoAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaCustomerInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaCustomerInfoUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaCustomerInfo get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaCustomerInfo> get(JavaCustomerInfoWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}")
    public Pagination<JavaCustomerInfo> get(JavaCustomerInfoWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }
}

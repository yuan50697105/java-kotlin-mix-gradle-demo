package com.example.demo.controller;

import com.example.demo.entity.JavaTable;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.entity.dto.JavaTableAddDTO;
import com.example.demo.entity.dto.JavaTableUpdateDTO;
import com.example.demo.entity.dto.JavaTableWrapper;
import com.example.demo.service.JavaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/table")
public class JavaTableController {
    private final JavaTableService javaTableService;

    @Autowired
    public JavaTableController(JavaTableService javaTableService) {
        this.javaTableService = javaTableService;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaTableAddDTO table, @PathVariable String type) {
        javaTableService.saveData(table, type);
    }

    @PostMapping("/{type}")
    public void postData2(JavaTableAddDTO table, @PathVariable String type) {
        javaTableService.saveData(table, type);
    }

    @PutMapping("{type}")
    public void putData1(JavaTableUpdateDTO table, @PathVariable String type) {
        javaTableService.updateData(table, type);
    }

    @PutMapping(value = "{type}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaTableUpdateDTO table, @PathVariable String type) {
        javaTableService.updateData(table, type);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id,@PathVariable String type) {
        javaTableService.deleteData(id, type);
    }

    @GetMapping("/{type}/{id}")
    public JavaTable get(@PathVariable Long id, @PathVariable String type) {
        return javaTableService.get(id, type);
    }

    @GetMapping("/{type}/list")
    public List<JavaTable> get(JavaTableWrapper wrapper, @PathVariable String type) {
        return javaTableService.getList(wrapper, type);
    }

    @GetMapping("/{type}/list")
    public Pagination<JavaTable> get(JavaTableWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return javaTableService.getPage(wrapper, page, size, type);
    }
}

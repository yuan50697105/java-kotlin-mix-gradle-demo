package com.example.demo.controller;

import com.example.demo.entity.JavaTable;
import com.example.demo.service.JavaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("java/table")
public class JavaTableController {
    private final JavaTableService javaTableService;

    @Autowired
    public JavaTableController(JavaTableService javaTableService) {
        this.javaTableService = javaTableService;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaTable table, @PathVariable String type) {
        javaTableService.saveData(table, type);
    }

    @PostMapping("/{type}")
    public void postData2(JavaTable table, @PathVariable String type) {
        javaTableService.saveData(table, type);
    }
}

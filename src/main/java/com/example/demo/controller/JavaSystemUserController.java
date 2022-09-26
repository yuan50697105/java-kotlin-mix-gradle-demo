package com.example.demo.controller;

import com.example.demo.entity.JavaSystemUser;
import com.example.demo.entity.dto.JavaSystemUserAddDTO;
import com.example.demo.entity.dto.JavaSystemUserUpdateDTO;
import com.example.demo.entity.dto.JavaSystemUserWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/system/user")
public class JavaSystemUserController {
    private final JavaSystemUserService javaTableService;

    @Autowired
    public JavaSystemUserController(JavaSystemUserService javaTableService) {
        this.javaTableService = javaTableService;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaSystemUserAddDTO table, @PathVariable String type) {
        javaTableService.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaSystemUserAddDTO table, @PathVariable String type) {
        javaTableService.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaSystemUserUpdateDTO table, @PathVariable String type) {
        javaTableService.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaSystemUserUpdateDTO table, @PathVariable String type) {
        javaTableService.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        javaTableService.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaSystemUser get(@PathVariable Long id, @PathVariable String type) {
        return javaTableService.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaSystemUser> get(JavaSystemUserWrapper wrapper, @PathVariable String type) {
        return javaTableService.getList(type, wrapper);
    }

    @GetMapping("/{type}/list")
    public Pagination<JavaSystemUser> get(JavaSystemUserWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return javaTableService.getPage(type, wrapper, page, size);
    }
}

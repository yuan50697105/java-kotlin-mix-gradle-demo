package com.example.demo.controller;

import cn.hutool.core.lang.tree.Tree;
import com.example.demo.entity.JavaSystemPermission;
import com.example.demo.entity.dto.JavaSystemPermissionAddDTO;
import com.example.demo.entity.dto.JavaSystemPermissionUpdateDTO;
import com.example.demo.entity.dto.JavaSystemPermissionWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/system/permission")
public class JavaSystemPermissionController {
    private final JavaSystemPermissionService service;

    @Autowired
    public JavaSystemPermissionController(JavaSystemPermissionService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaSystemPermissionAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaSystemPermissionAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaSystemPermissionUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaSystemPermissionUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaSystemPermission get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaSystemPermission> get(JavaSystemPermissionWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}")
    public Pagination<JavaSystemPermission> get(JavaSystemPermissionWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }

    @GetMapping("{type}/tree")
    public List<Tree<Long>> getTree(JavaSystemPermissionWrapper wrapper, String type) {
        return service.getTree(type, wrapper);
    }
}

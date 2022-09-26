package com.example.demo.controller;

import com.example.demo.entity.JavaSystemRole;
import com.example.demo.entity.dto.JavaSystemRoleAddDTO;
import com.example.demo.entity.dto.JavaSystemRoleUpdateDTO;
import com.example.demo.entity.dto.JavaSystemRoleWrapper;
import com.example.demo.entity.dto.Pagination;
import com.example.demo.service.JavaSystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("java/system/role")
public class JavaSystemRoleController {
    private final JavaSystemRoleService service;

    @Autowired
    public JavaSystemRoleController(JavaSystemRoleService service) {
        this.service = service;
    }

    @PostMapping(value = "/{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postData1(@RequestBody JavaSystemRoleAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PostMapping("/{type}")
    public void postData2(JavaSystemRoleAddDTO table, @PathVariable String type) {
        service.saveData(type, table);
    }

    @PutMapping("{type}")
    public void putData1(JavaSystemRoleUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @PutMapping(value = "{type}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putData2(@RequestBody JavaSystemRoleUpdateDTO table, @PathVariable String type) {
        service.updateData(type, table);
    }

    @DeleteMapping("/{type}/{id}")
    public void deleteData(@PathVariable Long[] id, @PathVariable String type) {
        service.deleteData(type, id);
    }

    @GetMapping("/{type}/{id}")
    public JavaSystemRole get(@PathVariable Long id, @PathVariable String type) {
        return service.get(type, id);
    }

    @GetMapping("/{type}/list")
    public List<JavaSystemRole> get(JavaSystemRoleWrapper wrapper, @PathVariable String type) {
        return service.getList(type, wrapper);
    }

    @GetMapping("/{type}/list")
    public Pagination<JavaSystemRole> get(JavaSystemRoleWrapper wrapper, @RequestParam int page, @RequestParam int size, @PathVariable String type) {
        return service.getPage(type, wrapper, page, size);
    }
}

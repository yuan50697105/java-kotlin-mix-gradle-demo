package com.example.demo.controller

import com.example.demo.entity.KotlinSystemPermission
import com.example.demo.entity.dto.KotlinSystemPermissionAddDTO
import com.example.demo.entity.dto.KotlinSystemPermissionUpdateDTO
import com.example.demo.entity.dto.KotlinSystemPermissionWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemPermissionService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/system/permission")
class KotlinSystemPermissionController(private val kotlinTableService: KotlinSystemPermissionService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinSystemPermissionAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinSystemPermissionAddDTO, type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinSystemPermissionUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinSystemPermissionUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinSystemPermission? {
        return kotlinTableService.get(id, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinSystemPermissionWrapper,
        @PathVariable type: String
    ): List<KotlinSystemPermission>? {
        return kotlinTableService.getList(wrapper, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinSystemPermissionWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinSystemPermission>? {
        return kotlinTableService.getPage(wrapper, page, size, type)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(id, type)
    }
}
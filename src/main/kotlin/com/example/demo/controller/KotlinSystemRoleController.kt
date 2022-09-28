package com.example.demo.controller

import com.example.demo.entity.KotlinSystemRole
import com.example.demo.entity.dto.KotlinSystemRoleAddDTO
import com.example.demo.entity.dto.KotlinSystemRoleUpdateDTO
import com.example.demo.entity.dto.KotlinSystemRoleWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemRoleService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/system/role")
class KotlinSystemRoleController(private val kotlinTableService: KotlinSystemRoleService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinSystemRoleAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinSystemRoleAddDTO, type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinSystemRoleUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinSystemRoleUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinSystemRole? {
        return kotlinTableService.get(id, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(wrapper: KotlinSystemRoleWrapper, @PathVariable type: String): List<KotlinSystemRole>? {
        return kotlinTableService.getList(wrapper, type)
    }

    @GetMapping("/{type}")
    operator fun get(
        wrapper: KotlinSystemRoleWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinSystemRole>? {
        return kotlinTableService.getPage(wrapper, page, size, type)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(id, type)
    }
}
package com.example.demo.controller

import com.example.demo.entity.KotlinSystemDepartment
import com.example.demo.entity.dto.KotlinSystemDepartmentAddDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentUpdateDTO
import com.example.demo.entity.dto.KotlinSystemDepartmentWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemDepartmentService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/system/department")
class KotlinSystemDepartmentController(private val kotlinTableService: KotlinSystemDepartmentService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinSystemDepartmentAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinSystemDepartmentAddDTO, type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinSystemDepartmentUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinSystemDepartmentUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinSystemDepartment? {
        return kotlinTableService.get(type, id)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinSystemDepartmentWrapper,
        @PathVariable type: String
    ): List<KotlinSystemDepartment>? {
        return kotlinTableService.getList(type, wrapper)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinSystemDepartmentWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinSystemDepartment>? {
        return kotlinTableService.getPage(type, wrapper, page, size)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(type, id)
    }
}
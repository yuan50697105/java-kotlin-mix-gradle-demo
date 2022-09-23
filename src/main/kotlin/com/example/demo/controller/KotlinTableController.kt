package com.example.demo.controller

import com.example.demo.entity.KotlinTable
import com.example.demo.entity.dto.KotlinTableAddDTO
import com.example.demo.entity.dto.KotlinTableUpdateDTO
import com.example.demo.entity.dto.KotlinTableWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinTableService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/table")
class KotlinTableController(private val kotlinTableService: KotlinTableService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinTableAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinTableAddDTO, type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinTableUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinTableUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinTable? {
        return kotlinTableService.get(id, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(wrapper: KotlinTableWrapper, @PathVariable type: String): List<KotlinTable>? {
        return kotlinTableService.getList(wrapper, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinTableWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinTable>? {
        return kotlinTableService.getPage(wrapper, page, size, type)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(id, type)
    }
}
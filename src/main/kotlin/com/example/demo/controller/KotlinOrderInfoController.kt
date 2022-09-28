package com.example.demo.controller

import com.example.demo.entity.KotlinOrderInfo
import com.example.demo.entity.dto.KotlinOrderInfoAddDTO
import com.example.demo.entity.dto.KotlinOrderInfoUpdateDTO
import com.example.demo.entity.dto.KotlinOrderInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinOrderInfoService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/order/info")
class KotlinOrderInfoController(private val kotlinTableService: KotlinOrderInfoService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinOrderInfoAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinOrderInfoAddDTO, type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinOrderInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinOrderInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinOrderInfo? {
        return kotlinTableService.get(type, id)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinOrderInfoWrapper,
        @PathVariable type: String
    ): List<KotlinOrderInfo>? {
        return kotlinTableService.getList(type, wrapper)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinOrderInfoWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinOrderInfo>? {
        return kotlinTableService.getPage(type, wrapper, page, size)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(type, id)
    }
}
package com.example.demo.controller

import com.example.demo.entity.KotlinCustomerInfo
import com.example.demo.entity.dto.KotlinCustomerInfoAddDTO
import com.example.demo.entity.dto.KotlinCustomerInfoUpdateDTO
import com.example.demo.entity.dto.KotlinCustomerInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinCustomerInfoService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/customer/info")
class KotlinCustomerInfoController(private val kotlinTableService: KotlinCustomerInfoService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinCustomerInfoAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinCustomerInfoAddDTO, type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinCustomerInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinCustomerInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinCustomerInfo? {
        return kotlinTableService.get(type, id)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinCustomerInfoWrapper,
        @PathVariable type: String
    ): List<KotlinCustomerInfo>? {
        return kotlinTableService.getList(type, wrapper)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinCustomerInfoWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinCustomerInfo>? {
        return kotlinTableService.getPage(type, wrapper, page, size)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(type, id)
    }
}
package com.example.demo.controller

import com.example.demo.entity.KotlinGoodsInfo
import com.example.demo.entity.dto.KotlinGoodsInfoAddDTO
import com.example.demo.entity.dto.KotlinGoodsInfoUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsInfoWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinGoodsInfoService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/goods/info")
class KotlinGoodsInfoController(private val kotlinTableService: KotlinGoodsInfoService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinGoodsInfoAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinGoodsInfoAddDTO, type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinGoodsInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinGoodsInfoUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinGoodsInfo? {
        return kotlinTableService.get(type, id)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinGoodsInfoWrapper,
        @PathVariable type: String
    ): List<KotlinGoodsInfo>? {
        return kotlinTableService.getList(type, wrapper)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinGoodsInfoWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinGoodsInfo>? {
        return kotlinTableService.getPage(type, wrapper, page, size)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(type, id)
    }
}
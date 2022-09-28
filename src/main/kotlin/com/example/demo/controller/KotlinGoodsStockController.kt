package com.example.demo.controller

import com.example.demo.entity.KotlinGoodsStock
import com.example.demo.entity.dto.KotlinGoodsStockAddDTO
import com.example.demo.entity.dto.KotlinGoodsStockUpdateDTO
import com.example.demo.entity.dto.KotlinGoodsStockWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinGoodsStockService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/goods/stock")
class KotlinGoodsStockController(private val kotlinTableService: KotlinGoodsStockService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinGoodsStockAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinGoodsStockAddDTO, type: String) {
        kotlinTableService.saveData(type, table)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinGoodsStockUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinGoodsStockUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(type, table)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinGoodsStock? {
        return kotlinTableService.get(type, id)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinGoodsStockWrapper,
        @PathVariable type: String,
    ): List<KotlinGoodsStock>? {
        return kotlinTableService.getList(type, wrapper)
    }

    @GetMapping("/{type}")
    operator fun get(
        wrapper: KotlinGoodsStockWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String,
    ): Pagination<KotlinGoodsStock>? {
        return kotlinTableService.getPage(type, wrapper, page, size)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(type, id)
    }
}
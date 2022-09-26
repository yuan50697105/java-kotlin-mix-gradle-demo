package com.example.demo.controller

import com.example.demo.entity.KotlinSystemUser
import com.example.demo.entity.dto.KotlinSystemUserAddDTO
import com.example.demo.entity.dto.KotlinSystemUserUpdateDTO
import com.example.demo.entity.dto.KotlinSystemUserWrapper
import com.example.demo.entity.dto.Pagination
import com.example.demo.service.KotlinSystemUserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("kotlin/system/user")
class KotlinSystemUserController(private val kotlinTableService: KotlinSystemUserService) {
    @PostMapping(value = ["/{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData1(@RequestBody table: KotlinSystemUserAddDTO, @PathVariable type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PostMapping("/{type}")
    fun postData2(table: KotlinSystemUserAddDTO, type: String) {
        kotlinTableService.saveData(table, type)
    }

    @PutMapping("{type}")
    fun putData1(table: KotlinSystemUserUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @PutMapping(value = ["{type}"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData2(@RequestBody table: KotlinSystemUserUpdateDTO, @PathVariable type: String) {
        kotlinTableService.updateData(table, type)
    }

    @GetMapping("/{type}/{id}")
    operator fun get(@PathVariable id: Long, @PathVariable type: String): KotlinSystemUser? {
        return kotlinTableService.get(id, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(wrapper: KotlinSystemUserWrapper, @PathVariable type: String): List<KotlinSystemUser>? {
        return kotlinTableService.getList(wrapper, type)
    }

    @GetMapping("/{type}/list")
    operator fun get(
        wrapper: KotlinSystemUserWrapper,
        @RequestParam page: Int,
        @RequestParam size: Int,
        @PathVariable type: String
    ): Pagination<KotlinSystemUser>? {
        return kotlinTableService.getPage(wrapper, page, size, type)
    }

    @DeleteMapping("/{type}/{id}")
    fun deleteData(@PathVariable id: Array<Long>, @PathVariable type: String) {
        kotlinTableService.deleteData(id, type)
    }
}
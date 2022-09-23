package com.example.demo.controller

import com.example.demo.entity.KotlinTable
import com.example.demo.service.KotlinTableService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("kotlin/table")
class KotlinTableController(private val kotlinTableService: KotlinTableService) {
    @PostMapping("/{type}")
    fun postData(@RequestBody kotlinTable: KotlinTable, @PathVariable type: String) {
        kotlinTableService.saveData(kotlinTable, type)

    }
}
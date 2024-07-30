package com.phooms.springboot.controllers

import com.phooms.springboot.models.Demodata
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class DemoController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello String Boot"
    }

    @GetMapping("/about")
    fun about(): String {
        return "about String Boot"
    }

    //    get all data demo
    @GetMapping("/demodata")
    fun getDemoData(): List<Demodata> {
        return listOf(
            Demodata(
                1,
                "John Doe",
                "john@example.com",
                "0888888888",
                "Eng",
            ),
            Demodata(
                2,
                "jane Doe",
                "jane@example.com",
                "0888888887",
                "Eng",
            ),
            Demodata(
                3,
                "jane Doe",
                "jane@example.com",
                "0888888880",
                "Eng",
            )
        )
    }

    //    get data by id
    @GetMapping("/demodata/{id}")
    fun getDemoById(@PathVariable id: Int): Demodata {
        return Demodata(
            1,
            "jane Doe",
            "jane@example.com",
            "0888888880",
            "Eng",
        )
    }

    //    post data
    @PostMapping("/demodata")
    fun createDemo(@RequestBody demodata: Demodata): Demodata {
        return demodata
    }

//    put datademo
    @PutMapping("/demodata/{id}")
    fun updateDemoData(@PathVariable id:Int, @RequestBody demodata: Demodata):Demodata{
        return demodata.copy(id = id)
    }

//    delete datademo
    @DeleteMapping("/demodata/{id}")
    fun deleteDemodata(@PathVariable id:Int):String{
        return "Delete Demodata ID:$id "
    }
}
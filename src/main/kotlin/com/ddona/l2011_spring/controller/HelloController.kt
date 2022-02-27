package com.ddona.l2011_spring.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/l2011")
class HelloController {


    @RequestMapping("/", method = [RequestMethod.GET, RequestMethod.POST])
    fun hello(): String {
        return "Welcome to L2011 from T3h love"
    }

    @GetMapping("/get")
    fun helloGet(): String {
        return "Welcome Spring with GetMapping annotation"
    }

    @PostMapping("/post")
    fun helloPost(): String {
        return "Welcome Spring with PostMapping annotation"
    }

    @PutMapping("/put")
    fun helloPut(): String {
        return "Welcome Spring with PostMapping annotation"
    }

    @DeleteMapping("/delete")
    fun helloDelete(): String {
        return "Welcome Spring with PostMapping annotation"
    }
}
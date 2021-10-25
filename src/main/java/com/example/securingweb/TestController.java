package com.example.securingweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /*** 测试资源1 * @return */
    @GetMapping(value = "/r/r1")
    public String r1(){ return " 访问资源1"; }


    /*** 测试资源2 * @return */
    @GetMapping(value = "/r/r2")
    public String r2(){ return " 访问资源2"; }
}

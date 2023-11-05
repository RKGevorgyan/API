package com.example.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/greeting")
public class HelloController {

    int userId;

    @GetMapping("hello-unnamed")
    public String getHello() {
        return "hello";
    }

    @GetMapping("hello/user/{userName}")
    public String getHelloByName(@PathVariable String userName) {
        return "hello " + userName;
    }

    @GetMapping("hello/user")
    public String getHelloByNameAndAge(@RequestParam String userName,
                                       @RequestParam Integer age) {
        String pensioner = "";
        if (age < 50) pensioner = "student";
        else pensioner = "pensioner";
        return "hello " + userName + ", ты - " + pensioner;
    }

    @PostMapping("hello/user/save")
    public Integer saveUser(@RequestParam String userName,
                         @RequestParam Integer age) {
        System.out.println(userName + " " + age);
        userId++;
        return userId;
    }
}

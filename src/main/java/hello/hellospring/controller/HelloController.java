package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//controller가 우선순위를 가짐
@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // 기본적으로 rsc / templates/ hello(viewName)를 찾음.
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name" , name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTML없이 문자 그대로 표현해서 나타내는 방식.
    public String helloString(@RequestParam("name") String name){

        return "hello " + name + " !!!  ";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

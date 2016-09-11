package com.zk.java.controller;

import com.zk.toolbox.biz.SimpleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return  SimpleService.getServiceDescription();
    }

    @RequestMapping("/json")
    @ResponseBody
    public String json(){
        String serviceDesc = SimpleService.getServiceDescription();

        return serviceDesc;
    }
}

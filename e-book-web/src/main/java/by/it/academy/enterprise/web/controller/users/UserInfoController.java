package by.it.academy.enterprise.web.controller.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserInfoController {
    @RequestMapping(value = "")
    public String request(){
        return "";
    }
}

package by.it.academy.enterprise.web.controller.reviewer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reviewer")
public class BookAddController {
    @RequestMapping(value = "")
    public String request(){
        return "";
    }
}

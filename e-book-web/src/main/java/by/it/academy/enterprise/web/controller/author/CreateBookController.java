package by.it.academy.enterprise.web.controller.author;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class CreateBookController {
    @RequestMapping(value = "")
    public String request(){
        return "";
    }
}

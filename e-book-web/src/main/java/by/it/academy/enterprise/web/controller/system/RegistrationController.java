package by.it.academy.enterprise.web.controller.system;

import by.it.academy.enterprise.service.services.dao.mongo.UsersService;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createAuthenticationToken(@RequestParam String username, @RequestParam String password,
                                            @RequestParam String mail) {
        usersService.setUserMc("system");
        Document document = usersService.setAllParamDoc(mail,username,password,"USER");
        Document checker = usersService.get(document);
        if(checker.containsValue(username)){
            return "This username already exists ";
        }else if(checker.containsValue(mail)){
            return "This mail already exists";
        }else if (mail.endsWith("@mail.ru")) {
            return "Your mail must end with @mail.ru";
        }else {
            BasicDBObject dbObject = usersService.setAllParamBasicM(mail,username,password,"USER");
            usersService.add(dbObject);
        return "Registration success";
        }
    }
}

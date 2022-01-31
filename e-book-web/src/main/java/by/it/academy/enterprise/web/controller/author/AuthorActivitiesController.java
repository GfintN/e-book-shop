package by.it.academy.enterprise.web.controller.author;

import by.it.academy.enterprise.entity.mongodb.AuthorActivities;
import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.enterprise.service.services.dao.mongo.AuthorActivitiesService;
import by.it.academy.enterprise.service.services.dao.mongo.UsersService;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("author")
public class AuthorActivitiesController {

    @Autowired
    AuthorActivitiesService authorActivitiesService;

    @Autowired
    AuthorActivities authorActivities;

    @Autowired
    Users users;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/add-activities")
    public String addActivities(@RequestParam LocalDateTime dateStart, @RequestParam LocalDateTime dateEnd,
                                @RequestParam String address){
        authorActivitiesService.setUserMc("author");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Document document = new Document();
        document.append(users.getUsername(), currentPrincipalName);
        document = usersService.get(document);
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append(authorActivities.getAuthorId(),document.get("_id"))
                .append(authorActivities.getDateOfStart(),dateStart)
                .append(authorActivities.getDateOfEnd(), dateEnd)
                .append(authorActivities.getAddress(), address);
        authorActivitiesService.add(dbObject);
        return "Activities added";
    }


}

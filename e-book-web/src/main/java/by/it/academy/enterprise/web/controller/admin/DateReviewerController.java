package by.it.academy.enterprise.web.controller.admin;

import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.enterprise.entity.postgresql.ReviewerInfo;
import by.it.academy.enterprise.service.services.dao.mongo.UsersService;
import by.it.academy.enterprise.service.services.dao.postgres.ReviewerInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("admin")
public class DateReviewerController {

    @Autowired
    ReviewerInfoService reviewerInfoService;

    @Autowired
    UsersService usersService;

    @Autowired
    Users users;

    @RequestMapping(value = "/reviewers/add")
    public String addReviewer(@RequestParam String firstName, @RequestParam String surName,
                              @RequestParam String patronymic, @RequestParam String macAddress,
                              @RequestParam String username){
        reviewerInfoService.setUserEm("admin");
        ReviewerInfo reviewerInfo = new ReviewerInfo();
        Document document = new Document();
        document.append(users.getUsername(),username);
        document = usersService.get(document);
        Document update = document;
        update.append(users.getStatus(),"REVIEWER");
        usersService.update(document, update);
        reviewerInfo.setUserId((Long) document.get("_id"));
        reviewerInfo.setFirstName(firstName);
        reviewerInfo.setSurName(surName);
        reviewerInfo.setPatronymic(patronymic);
        reviewerInfo.setMacAddress(macAddress);
        reviewerInfo.setHiringDate(LocalDate.now());
       reviewerInfoService.add(reviewerInfo);
        return "Add Reviewer Success";
    }

    @RequestMapping(value = "/reviewers/delete-by-id")
    public String deleteReviewer(@RequestParam Long id){
        reviewerInfoService.setUserEm("admin");
        Document document = new Document();
        document.append(users.getUsername(),reviewerInfoService.getById(id).getUserId());
        document = usersService.get(document);
        Document update = document;
        update.append(users.getStatus(),"USER");
        usersService.update(document, update);
        reviewerInfoService.deleteById(id);
        return "Delete Reviewer Success";
    }

    @RequestMapping(value = "/reviewers/get-by-username")
    public String getReviewer( @RequestParam String username, @RequestParam(required = false) int limit){
        reviewerInfoService.setUserEm("admin");
        Document document = new Document();
        document.append(users.getUsername(),username);
        document = usersService.get(document);
        List<ReviewerInfo> list = reviewerInfoService.getByColumn("userId", (String) document.get("_id"), limit);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "JSON parsing Error";
        }
    }

    @RequestMapping(value = "/reviewers/get-by-id")
    public String getReviewer( @RequestParam Long id){
        reviewerInfoService.setUserEm("admin");
        ReviewerInfo reviewerInfo = reviewerInfoService.getById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(reviewerInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "JSON parsing Error";
        }
    }
}

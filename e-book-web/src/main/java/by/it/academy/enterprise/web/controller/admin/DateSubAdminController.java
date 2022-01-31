package by.it.academy.enterprise.web.controller.admin;

import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.enterprise.entity.postgresql.SubAdminDeleteRequests;
import by.it.academy.enterprise.entity.postgresql.SubAdminInfo;
import by.it.academy.enterprise.service.services.dao.mongo.UsersService;
import by.it.academy.enterprise.service.services.dao.postgres.SubAdminDeleteRequestsService;
import by.it.academy.enterprise.service.services.dao.postgres.SubAdminInfoService;
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
public class DateSubAdminController {

    @Autowired
    SubAdminInfoService subAdminInfoService;

    @Autowired
    SubAdminDeleteRequestsService subAdminDeleteRequests;

    @Autowired
    UsersService usersService;

    @Autowired
    Users users;

    @RequestMapping(value = "/sub-admins/add")
    public String addReviewer(@RequestParam String firstName, @RequestParam String surName,
                              @RequestParam String patronymic, @RequestParam String macAddress,
                              @RequestParam String username, @RequestParam String workingMail){
      if(workingMail.endsWith("@mail.ru")) {
          subAdminInfoService.setUserEm("admin");
          SubAdminInfo reviewerInfo = new SubAdminInfo();
          Document document = new Document();
          document.append(users.getUsername(), username);
          document = usersService.get(document);
          Document update = document;
          update.append(users.getStatus(),"ADMIN");
          reviewerInfo.setUserId((Long) document.get("_id"));
          reviewerInfo.setFirstName(firstName);
          reviewerInfo.setSurName(surName);
          reviewerInfo.setPatronymic(patronymic);
          reviewerInfo.setMacAddress(macAddress);
          reviewerInfo.setWorkingMail(workingMail);
          subAdminInfoService.add(reviewerInfo);
          return "Add Reviewer Success";
      }else {
          return  "Your mail must end with @mail.ru";
      }
    }

    @RequestMapping(value = "/sub-admins/delete-by-id")
    public String deleteSubAdmin(@RequestParam Long id, @RequestParam String password){
        subAdminInfoService.setUserEm("admin");
        Document checker = new Document();
        checker.append(users.getUsername(),"admin");
        checker = usersService.get(checker);
        if(checker.get(users.getPassword()).equals(password)){
            Document document = new Document();
            document.append(users.getUsername(),subAdminInfoService.getById(id).getUserId());
            document = usersService.get(document);
            Document update = document;
            update.append(users.getStatus(),"USER");
            usersService.update(document, update);
            subAdminInfoService.deleteById(id);
        return "Delete Reviewer Success";
        }else {
        return "You not main admin";
        }
    }

    @RequestMapping(value = "/sub-admins/get-by-username")
    public String getReviewer( @RequestParam String username, @RequestParam(required = false) int limit){
        subAdminInfoService.setUserEm("admin");
        Document document = new Document();
        document.append(users.getUsername(),username);
        document = usersService.get(document);
        List<SubAdminInfo> list = subAdminInfoService.getByColumn("userId", (String) document.get("_id"), limit);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "JSON parsing Error";
        }
    }

    @RequestMapping(value = "/sub-admins/get-by-id")
    public String getReviewer( @RequestParam Long id){
        subAdminInfoService.setUserEm("admin");
        SubAdminInfo reviewerInfo = subAdminInfoService.getById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(reviewerInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "JSON parsing Error";
        }
    }

    @RequestMapping(value = "/sub-admins/add-del-request")
    public String addAdminDelRequest(@RequestParam String causeDismissal){
        subAdminDeleteRequests.setUserEm("admin");
        SubAdminDeleteRequests subAdminDeleteRequests = new SubAdminDeleteRequests();
        subAdminDeleteRequests.setCauseDismissal(causeDismissal);
        subAdminDeleteRequests.setRequestsDate(LocalDate.now());
        this.subAdminDeleteRequests.add(subAdminDeleteRequests);
        return "Delete Request added";
    }
}

package by.it.academy.enterprise.web.controller.admin;

import by.it.academy.enterprise.entity.mongodb.BlockList;
import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.enterprise.service.services.dao.mongo.BlockListService;
import by.it.academy.enterprise.service.services.dao.mongo.UsersService;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("admin")
public class BlockListController {

    @Autowired
    BlockListService blockListService;

    @Autowired
    UsersService usersService;

    @Autowired
    Users users;

    @Autowired
    BlockList blockList;

    @RequestMapping(value = "/block-user")
    public String blockUser(@RequestParam String username, @RequestParam LocalDateTime dateEndBlock,
                            @RequestParam String reason){
        blockListService.setUserMc("admin");
        Document checker = new Document();
        checker.append(users.getUsername(), username);
        checker = usersService.get(checker);
        if (checker.get(users.getStatus()).equals("ADMIN")){
        BasicDBObject document = blockListService.setAllParamBasicM(username,reason,LocalDateTime.now(),dateEndBlock);
        blockListService.add(document);
        return "User added in block list";}
        else {
            return "Admin blocking disabled";
        }
    }

    @RequestMapping(value = "/unblock-user")
    public String unblockUser(@RequestParam String username){
            blockListService.setUserMc("admin");
            blockListService.delete(blockList.getUserName(),username);
            return "User added in block list";
    }

}

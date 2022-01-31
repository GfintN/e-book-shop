package by.it.academy.enterprise.web.controller.system;

import by.it.academy.enterprise.entity.mongodb.Books;
import by.it.academy.enterprise.service.services.dao.mongo.BooksService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowBooksController {
    @Autowired
    BooksService booksService;

    @RequestMapping(value = "/books/get-all", method = RequestMethod.GET)
    public String getAllBooks() {
        booksService.setUserMc("system");
            List<DBObject> bookList = booksService.getAllCollection();
            return bookList.toString();
    }

    @RequestMapping(value = "/books/get-all-where-cost", method = RequestMethod.GET)
    public String getAllBooksWhereCost(@RequestParam Long bookCost) {
        booksService.setUserMc("system");
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append(new Books().getCost(), bookCost);
        List<DBObject> bookList = booksService.getAll(dbObject);
        return bookList.toString();
    }

    @RequestMapping(value = "/books/get", method = RequestMethod.GET)
    public String getBookForName(@RequestParam Long bookName) {
        booksService.setUserMc("system");
        Document dbObject = new Document();
        dbObject.append(new Books().getBookName(), bookName);
        dbObject = booksService.get(dbObject);
        return dbObject.toString();
    }


    @RequestMapping(value = "/books/get-all-where-id", method = RequestMethod.GET)
    public String getAllBooksWhereId(@RequestParam(required = false) Long maxId,
                                            @RequestParam(required = false) Long minId) {
        booksService.setUserMc("system");
        List<DBObject> bookList = booksService.getWareId(minId,maxId);
        return bookList.toString();
    }

}

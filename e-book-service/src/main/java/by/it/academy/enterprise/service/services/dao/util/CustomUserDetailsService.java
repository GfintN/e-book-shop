package by.it.academy.enterprise.service.services.dao.util;

import by.it.academy.enterprise.entity.mongodb.Users;
import by.it.academy.example.persistence.dao.impl.mongodb.UsersDAOImpl;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersDAOImpl dao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Document document = new Document();
        Users users = new Users();
        document.append(users.getUsername(), userName);
        Document myUser= dao.get(document);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        UserDetails user = User.builder()
                .username((String) myUser.get(users.getUsername()))
                .password((String) myUser.get(users.getPassword()))
                .roles((String) myUser.get(users.getStatus()))
                .build();
        return user;
    }
}

package by.it.academy.enterprise.web.controller.system;

import by.it.academy.enterprise.entity.mongodb.BlockList;
import by.it.academy.enterprise.service.services.dao.mongo.BlockListService;
import by.it.academy.enterprise.service.services.dao.util.AuthRequest;
import by.it.academy.enterprise.service.services.dao.util.AuthResponse;
import by.it.academy.enterprise.service.services.dao.util.JWTUtil;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import java.time.LocalDateTime;

@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    BlockListService blockListService;

    @Autowired
    private JWTUtil jwtTokenUtil;


    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication;
        Document document = new Document();
        BlockList blockList = new BlockList();
        document = blockListService.get(document.append(blockList.getUserName(),authRequest.getName()));
        if(document.containsValue(authRequest.getName()))
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            if(localDateTime.isAfter((LocalDateTime) document.get(blockList.getDateEndBlock()))){
                return null;
            }
        }
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
            System.out.println(authentication);
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login or password wrong", e);
        }
        String jwt = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        Cookie token = new Cookie("token", jwt);

        return new AuthResponse(jwt);

    }
}

package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/users", consumes = MediaType.ALL_VALUE)
public class UsersController {

    private UsersCatalog usersCatalog;

    @Autowired
    public void setUsersCatalog(UsersCatalog usersCatalog) {
        this.usersCatalog = usersCatalog;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<UserInfo> getAll(){
        return usersCatalog.getAll();
    }

    @GetMapping
    public UserInfo getById(@RequestParam("userId") String id){
        return usersCatalog.getById(id);
    }

    @DeleteMapping
    public UserInfo deleteById(@RequestParam("userId") String id){
        return usersCatalog.deleteById(id);
    }

    @DeleteMapping("/{userId}")
    public UserInfo deleteByIdFromPath(@PathVariable("userId") String id){
        return usersCatalog.deleteById(id);
    }

    @PostMapping(value = "/create")
    public UserInfo createUser(@RequestBody UserInfo userInfo){
        return usersCatalog.create(userInfo);
    }

    @PostMapping(value = "/update")
    public UserInfo updateUser(@RequestBody UserInfo userInfo){
        return usersCatalog.update(userInfo);
    }
}

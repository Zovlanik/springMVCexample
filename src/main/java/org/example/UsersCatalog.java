package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UsersCatalog {

    private Map<String, UserInfo> users = new HashMap<>();


    @PostConstruct
    public void init(){
        create(new UserInfo("1", "Vladimir"));
        create(new UserInfo("2", "Alex"));
    }

    public Collection<UserInfo> getAll() {
        return users.values();
    }

    public UserInfo create(UserInfo userInfo) {
        users.put(userInfo.getId(), userInfo);
        return userInfo;
    }

    public UserInfo update(UserInfo userInfo) {
        users.put(userInfo.getId(), userInfo);
        return userInfo;
    }

    public UserInfo deleteById(String id) {
        return users.remove(id);
    }

    public UserInfo getById(String id) {
        return users.get(id);
    }
}

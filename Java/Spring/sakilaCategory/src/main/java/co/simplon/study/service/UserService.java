package co.simplon.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import co.simplon.study.domain.User;

@Service
public class UserService {

    private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    
    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("manu", "password111", "elepevedic@simplon.co");
        User user2 = new User("nico", "password222", "nhovart@simplon.co");
        User user3 = new User("laetitia", "password333", "lamourous@simplon.co");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }

}

package com.github.pedrobacchini.springdatarest;

import com.github.pedrobacchini.springdatarest.entity.Group;
import com.github.pedrobacchini.springdatarest.entity.User;
import com.github.pedrobacchini.springdatarest.repository.GroupRepository;
import com.github.pedrobacchini.springdatarest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public SpringDataRestApplication(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Group a = new Group("A");
        Group b = new Group("B");
        Group c = new Group("C");

        User jsmith = new User("jsmith", "John", "Smith");
        User jwatson = new User("jwatson", "Jack", "Watson");
        User mcruz = new User("mcruz", "Marcus", "Cruz");

        a.addUser(jsmith);
        a.addUser(jwatson);
        a.addUser(mcruz);

        groupRepository.saveAll(Arrays.asList(a, b, c));
        userRepository.saveAll(Arrays.asList(jsmith, jwatson, mcruz));


    }
}

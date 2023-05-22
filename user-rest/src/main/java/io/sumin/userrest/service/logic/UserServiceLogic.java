package io.sumin.userrest.service.logic;

import io.sumin.userrest.entity.User;
import io.sumin.userrest.service.UserService;
import io.sumin.userrest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // 방법3
public class UserServiceLogic implements UserService {

    // @Autowired // 방법1
    private final UserStore userStore; // final은 방법3

//    public UserServiceLogic(UserStore userStore){
//        this.userStore = userStore; // 방법2 (생성자를 통한 주입)
//    }

    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}

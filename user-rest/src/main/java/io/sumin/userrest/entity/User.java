package io.sumin.userrest.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString // Lombok을 추가했기 때문에 이 어노테이션들을 사용할 수 있다.
public class User {

    private String id;
    private String name;
    private String email;

    public User(){
        this.id = UUID.randomUUID().toString(); //랜덤한 id 부여
    }
    public User(String name, String email){
        this(); // id 만드는 생성자 호출
        this.name = name;
        this.email = email;
    }

    public static User sample(){
        return new User("Park", "park@naver.io"); // test를 위한 샘플
    }
    public static void main(String[] args){
        User user = new User("Kim", "kim@naver.io");
        System.out.println(new Gson().toJson(user));
    }
}

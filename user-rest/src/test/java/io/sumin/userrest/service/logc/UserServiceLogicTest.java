package io.sumin.userrest.service.logc;

import io.sumin.userrest.entity.User;
import io.sumin.userrest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class UserServiceLogicTest {

    @Autowired
    private UserService userService;

    private User kim;
    private User lee;
    @BeforeEach // 테스트를 위한 기본적인 데이터 세팅
    public void starUp(){
        this.kim = new User("Kim", "Kim@naver.io");
        this.lee = new User("Lee", "Lee@naver.io");
        this.userService.register(kim);
        this.userService.register(lee);
    }
    @Test
    public void registerTest(){

        User sample = User.sample();
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3); //예상되는 사이즈
        this.userService.remove(sample.getId());
    }

    @Test
    public void find(){
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());

    }

    @AfterEach // 테스트에서 사용되었던 임의의 값들을 삭제
    public void cleanUp(){
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }
}

package com.lyq3.rabbit.springboot.object;

import com.lyq3.rabbit.springboot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ObjectTest {

    @Autowired
    private Sender sender;

    @Test
    public void object() throws Exception {
        User user = new User();
        user.setName("卡卢比");
        user.setAge(25);
        user.setHeight(180);
        user.setWeight(130.5);
        user.setSex('M');
        sender.sendObject(user);
    }

}

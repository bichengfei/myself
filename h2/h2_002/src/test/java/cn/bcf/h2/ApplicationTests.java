package cn.bcf.h2;

import cn.bcf.h2.entity.UserEntity;
import cn.bcf.h2.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test001() {
        List<UserEntity> list = userMapper.selectAll();
        list.stream().forEach(System.out::println);
    }
}

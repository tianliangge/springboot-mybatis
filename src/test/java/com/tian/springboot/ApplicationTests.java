package com.tian.springboot;

import java.util.List;

import com.tian.springboot.domain.User;
import com.tian.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
    UserMapper userMapper;

	@Test
	public void contextLoads() {
		Page<Object> page=PageHelper.startPage(1,5);
		List<User> list = userMapper.queryAllUser();
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("共"+page.getTotal()+"条");
		System.out.println();
	}
	
	@Test
	public void initData() {
		for (int i = 1; i <=10; i++) {
			userMapper.insert(new User("小明"+i, "武汉"+i));
		}
		
	}

}


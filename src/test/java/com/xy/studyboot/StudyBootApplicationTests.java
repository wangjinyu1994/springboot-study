package com.xy.studyboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xy.studyboot.dao.TestMapper;
import com.xy.studyboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyBootApplicationTests {

	//@Autowired
	//private TestRestTemplate testRestTemplate;

	@Autowired
	private TestMapper dao;

/*	@LocalServerPort
	private LocalServerPort port;*/

	@Test
	public void contextLoads() {

		List<User> list = dao.getList();
		System.out.println(list.get(0).toString());
		List<User> list1 = dao.getAllUser();
		PageInfo<User> pageInfo = PageHelper.startPage(1,10).setOrderBy("id DESC").doSelectPageInfo(()->this.dao.getAllUser());
		List<User> list2 = pageInfo.getList();
		System.out.println(list2.get(0).toString() + "*****" + pageInfo.getTotal());
		System.out.println("=========" + list1.get(0).toString());

	}
}

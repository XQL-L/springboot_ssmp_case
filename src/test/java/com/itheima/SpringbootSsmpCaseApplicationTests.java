package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootSsmpCaseApplicationTests {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private BookService bookService;

	@Test
	void daotests() {
		System.out.println(bookDao.selectById(1));
	}
	@Test
	void servicetests() {
		IPage<Book> page = bookService.getPage(2, 5);
		System.out.println(page.getRecords());

	}

}

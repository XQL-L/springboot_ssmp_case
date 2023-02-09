package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        int influence = bookDao.insert(book);
        return influence>0;
    }

    @Override
    public Boolean update(Book book) {
//        Wrapper<Book> wp = new QueryWrapper<>();
        int influence = bookDao.updateById(book);
        return influence>0;

    }

    @Override
    public Boolean delete(Integer id) {
        int influence = bookDao.deleteById(id);
        return influence>0;
    }

    @Override
    public Boolean deleteByIds(List<Integer> ids) {
        int influence = bookDao.deleteBatchIds(ids);
        return influence>0;

    }

    @Override
    public Book getById(Integer id) {
        Book book = bookDao.selectById(id);
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = bookDao.selectList(null);
        return books;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage,pageSize);
        IPage<Book> bookIPage = bookDao.selectPage(page, null);
        return bookIPage;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book querybook) {
        if(null == querybook){
            return getPage(currentPage,pageSize);
        }
        IPage<Book> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Book> qw = new QueryWrapper<>();

        qw.like(Strings.isNotEmpty(querybook.getType()),"type",querybook.getType());
        qw.like(Strings.isNotEmpty(querybook.getName()),"name",querybook.getName());
        qw.like(Strings.isNotEmpty(querybook.getDescription()),"description",querybook.getDescription());
        IPage<Book> bookIPage = bookDao.selectPage(page, qw);
        return bookIPage;
    }
}

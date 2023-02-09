package com.itheima.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.Result;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result getAll(){
        return new Result(true,bookService.getAll());
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws Exception {
//        if(book.getName().equals("xx"))throw new Exception();
        Boolean flag = bookService.save(book);
        return new Result(flag,flag?"添加成功^_^":"添加失败-_-!");
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(bookService.update(book));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(bookService.delete(id));
    }

    @DeleteMapping
    public Result deleteByIds(@RequestBody List<Integer> ids){
        System.out.println(ids);
        return new Result(bookService.deleteByIds(ids));

    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){//url传参不要加PathVariable
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if(currentPage>page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new Result(true,page);
    }
}

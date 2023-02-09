package com.itheima.test;

import lombok.Data;
import com.itheima.domain.Book;
@Data
class Result{
    private boolean flag;
    private Object data;
    private String msg;

    public Result() {
    }

    public Result(boolean flag) {
        this.flag = flag;
    }


    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag,String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}


public class Test {
    public static void main(String[] args) {
        int[] ints = {1, 2};
        System.out.println(new Result(true,"我是String"));
        Book book = new Book();
        book.setName("谢");
        System.out.println(new Result(false,book));
        System.out.println(new Result(true,new int[]{1,2}));
    }
}

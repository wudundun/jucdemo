package com.atguigu;

import sun.security.provider.MD2;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}
class MyThread2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"===Callable===");
        TimeUnit.SECONDS.sleep(4);
        return 200;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<>(new MyThread2());
        FutureTask<Integer> ft2 = new FutureTask<Integer>(()->{
            System.out.println(Thread.currentThread().getName()+"===Callable====");
            TimeUnit.SECONDS.sleep(6);
            return 1024;
        });
        new Thread(ft,"aa").start();
        new Thread(ft2,"bb").start();
        System.out.println(Thread.currentThread().getName());
        System.out.println(ft.get());
        System.out.println(ft2.get());
    }
}

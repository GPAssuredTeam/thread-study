package com.zhangchao.study.thread.base.deadlock;

import java.util.ArrayList;
import java.util.List;

public class Allocate {

     List<Object> list = new ArrayList<>();

    public synchronized boolean apply(Object from, Object to){
        if(list.contains(from) || list.contains(to)){
            return false;
        }
        list.add(from);
        list.add(to);
        return true;
    }

    public void release(Object from, Object to){
        list.remove(from);
        list.remove(to);
    }

}

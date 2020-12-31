package com.zhangchao.study.thread.base.hashmap;

public class HashMapTest {

    public static void main(String[] args) {
        System.out.println(100000000 >>> 16);
        Object key  = new Object();
        int h;
        int i = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i);
    }
}

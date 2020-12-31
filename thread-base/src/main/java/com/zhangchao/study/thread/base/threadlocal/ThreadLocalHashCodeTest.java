package com.zhangchao.study.thread.base.threadlocal;

public class ThreadLocalHashCodeTest {

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        hashIncrement(16);



    }

    public static void hashIncrement(int size){
        int hashcode = 0;
        for(int i=0;i<size;i++){
            hashcode = (i+1)*HASH_INCREMENT;
            System.out.print((hashcode&(size-1))+" ");
        }
        int n = 3;
        System.out.println();
        System.out.println( n >>>= 1);
        System.out.println( n );

    }
}

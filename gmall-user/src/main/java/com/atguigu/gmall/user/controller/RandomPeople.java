package com.atguigu.gmall.user.controller;

import java.util.Random;

public class RandomPeople {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(4) + 1);
    }
}

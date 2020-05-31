package com.hhu;

import com.hhu.entities.User;
import com.hhu.service.WebClientService;
import com.hhu.service.WebClientServiceImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        WebClientService webClientService = new WebClientServiceImpl();
        Scanner scanner = new Scanner(System.in);

        String id = scanner.nextLine();

        String pwd = scanner.next();
        try {
            if (webClientService.checkIn(new User(id, pwd))) {
                System.out.println("打卡成功");
            } else {
                System.out.println("打卡失败");
            }
        } catch (IOException e) {
            System.out.println("连接失败");
        }
    }
}

package com.edubridge.fanapp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.fanapp.model.Fan;
import com.edubridge.fanapp.service.FanService;

public class FanApp {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        FanService service = new FanService();
        String brand, color;
        int speed;
        double weight, price;

        do {
            System.out.println("Welcome to Fan Application");
            System.out.println("==========================");
            System.out.println("1. Add Fan");
            System.out.println("2. View All Fans");
            System.out.println("3. Search Fan");
            System.out.println("4. Update Fan");
            System.out.println("5. Delete Fan");
            System.out.println("6. Delete All Fans");
            System.out.println("0. Exit");
            System.out.println("Please choose an option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Add New Fan");
                    System.out.println("-----------");
                    System.out.println("Enter Fan Brand: ");
                    brand = in.next();
                    System.out.println("Enter Fan Color: ");
                    color = in.next();
                    System.out.println("Enter Fan Speed: ");
                    speed = in.nextInt();
                    System.out.println("Enter Fan Weight: ");
                    weight = in.nextDouble();
                    System.out.println("Enter Fan Price: ");
                    price = in.nextDouble();

                    Fan fan = new Fan();
                    fan.setBrand(brand);
                    fan.setColor(color);
                    fan.setSpeed(speed);
                    fan.setWeight(weight);
                    fan.setPrice(price);

                    service.addFan(fan);
                    break;

                case 2:
                    System.out.println("View All Fans");
                    System.out.println("-------------");
                    List<Fan> fans = service.getAllFans();
                    if (fans.size() != 0) {
                        for (Fan f : fans) {
                            System.out.println(f.getId() + "\t" + f.getBrand() + "\t" + f.getColor() + "\t" +
                                               f.getSpeed() + "\t" + f.getWeight() + "\t" + f.getPrice());
                        }
                    } else {
                        System.out.println("No fans found.");
                    }
                    break;

                case 3:
                    System.out.println("Search Fan");
                    System.out.println("----------");
                    System.out.println("Please enter fan id: ");
                    int id = in.nextInt();
                    Fan f = service.getFanById(id);
                    if (f != null) {
                        System.out.println("Fan Brand: " + f.getBrand());
                        System.out.println("Fan Color: " + f.getColor());
                        System.out.println("Fan Speed: " + f.getSpeed());
                        System.out.println("Fan Weight: " + f.getWeight());
                        System.out.println("Fan Price: " + f.getPrice());
                    } else {
                        System.out.println("No fan found with id: " + id);
                    }
                    break;

                case 4:
                    System.out.println("Update Fan Details");
                    System.out.println("------------------");
                    System.out.println("Enter Fan Id: ");
                    int fanId = in.nextInt();
                    System.out.println("Enter Fan Brand: ");
                    brand = in.next();
                    System.out.println("Enter Fan Color: ");
                    color = in.next();
                    System.out.println("Enter Fan Speed: ");
                    speed = in.nextInt();
                    System.out.println("Enter Fan Weight: ");
                    weight = in.nextDouble();
                    System.out.println("Enter Fan Price: ");
                    price = in.nextDouble();

                    Fan updatedFan = new Fan();
                    updatedFan.setId(fanId);
                    updatedFan.setBrand(brand);
                    updatedFan.setColor(color);
                    updatedFan.setSpeed(speed);
                    updatedFan.setWeight(weight);
                    updatedFan.setPrice(price);

                    service.updateFan(updatedFan);
                    break;

                case 5:
                    System.out.println("Delete Fan");
                    System.out.println("----------");
                    System.out.println("Please enter fan id: ");
                    int fanToDelete = in.nextInt();
                    service.deleteFan(fanToDelete);
                    break;

                case 6:
                    System.out.println("Are you sure you want to delete all fans? [Y/N]");
                    String confirm = in.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        service.deleteAllFans();
                    }
                    break;

                case 0:
                    System.out.println("Bye!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose the correct option.");
                    break;
            }
        } while (option != 0);
    }
}

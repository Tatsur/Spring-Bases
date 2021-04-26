package com.ttsr.client;

import com.ttsr.service.CartService;
import com.ttsr.spring.ComponentMainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentMainConfig.class);
        Scanner scanner = new Scanner(System.in);

        cartOp(context, scanner);

        cartOp(context, scanner);
    }

    private static void cartOp(ApplicationContext context, Scanner scanner) {

        CartService cart = context.getBean("cart", CartService.class);

        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();
            if (command.equals("add")) {
                cart.addById(getProductId(scanner));
                System.out.println(cart.getCartList());
            } else if (command.equals("del")) {
                cart.deleteById(getProductId(scanner));
                System.out.println(cart.getCartList());
            } else if (command.equals("end")) {
                System.out.println("Exit confirmed");
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private static int getProductId(Scanner scanner) {
        System.out.println("Enter product id: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        return productId;
    }

}

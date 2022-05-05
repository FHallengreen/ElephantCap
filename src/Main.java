import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> orders = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    double taxRate;

    public void createOrder() {
        System.out.println("Type your order to be created:");
        String order = sc.next();
        orders.add(order);
        selectPrice();
    }

    public void selectPrice() {
        System.out.println("Enter order value");
        double orderPrice = sc.nextDouble();
        price.add(orderPrice);
        newOrder();
    }

    private void newOrder() {
        System.out.println("Would you like to add another order?");
        System.out.println("Press 1 to create new order.");
        System.out.println("Press 2 to continue");
        boolean newOrder = true;
        while (newOrder) {
            switch (sc.nextLine()) {
                case "1" -> {
                    createOrder();
                    newOrder = false;
                }
                case "2" -> {
                    selectState();
                    newOrder = false;
                }
                default -> System.out.println("Please type either 1 or 2");
            }
        }
    }

    private void selectState() {
        System.out.println("Which state will the order be shipped to? (CA, UT, TX, AL, NV)");
        String choice = sc.next();
        choice = choice.toUpperCase();
        boolean run = true;
        while (run) {
            switch (choice) {
                case "UT" -> {
                    taxRate = 0.0685;
                    run = false;
                }
                case "NV" -> {
                    taxRate = 0.08;
                    run = false;
                }
                case "TX" -> {
                    taxRate = 0.0625;
                    run = false;
                }
                case "AL" -> {
                    taxRate = 0.04;
                    run = false;
                }
                case "CA" -> {
                    taxRate = 0.0825;
                    run = false;
                }
                default -> run = true;
            }
        }
        System.out.println("Your tax rate amounts to " + (taxRate*100) + " %");
    }

    public void showDiscount() {
        double totalPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            totalPrice += price.get(i);
        }
        System.out.println("Your total purchase is " + totalPrice + " USD");

        if (totalPrice >= 1000 && totalPrice < 5000) {
           totalPrice *= 0.97;
        } else if (totalPrice >= 5000 && totalPrice < 7000){
            totalPrice *= 0.95;
        }
        else if (totalPrice >= 7000 && totalPrice < 10000){
            totalPrice *= 0.93;
        }
        else if (totalPrice >= 10000 && totalPrice < 50000){
            totalPrice *= 0.90;
        }
        else if (totalPrice >=50000){
            totalPrice *= 0.85;
        }
        else System.out.println("No discount applicable");
        double twoDecimal = Math.floor(totalPrice * 100) / 100;
        System.out.println("Your total cost after discount is: " + twoDecimal + " USD");
        showFinalPrice(twoDecimal);
    }



    public void showFinalPrice(double discountedPrice){
        double finalPrice = Math.floor(discountedPrice * (1+taxRate) * 100 / 100);
        System.out.println("The total price is: " + finalPrice);
    }

    public void execute() {
        createOrder();
        showDiscount();

    }


    public static void main(String[] args) {
        new Main().execute();

    }
}

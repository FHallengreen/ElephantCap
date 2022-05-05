import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    ArrayList <String> orders = new ArrayList<>();
    ArrayList <Double> price = new ArrayList<>();

    public void createOrder() {
        System.out.println("Type your order to be created");
        Scanner sc = new Scanner(System.in);
        String order = sc.next();
        orders.add(order);
    }

    public void selectPrice() {
        System.out.println("Enter order value");
        Scanner sc = new Scanner(System.in);
        double orderPrice = sc.nextDouble();
        price.add(orderPrice);

        System.out.println("Would you like to add another order?");

    }

    public void execute(){
        createOrder();
        selectPrice();

    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.execute();
        new Main().execute();

    }
}

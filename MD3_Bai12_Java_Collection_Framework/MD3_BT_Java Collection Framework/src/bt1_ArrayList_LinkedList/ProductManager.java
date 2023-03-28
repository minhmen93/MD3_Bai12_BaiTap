package bt1_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct() {
        while (true){
            System.out.println("1: Create Product");
            System.out.println("2: Exit");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 2 -> {
                    return;
                }
                case 1 -> {
                    int id = productList.size();
                    System.out.print("Input name: ");
                    String name = sc.nextLine();
                    System.out.print("Input price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    Product product = new Product(id, name, price);
                    productList.add(product);
                    System.out.println("San pham: " + product + " duoc them thanh cong!");
                }
            }
        }
    }


    public void update() {
        display();
        System.out.print("Nhap id san pham can update");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input price: ");
        double price = Double.parseDouble(sc.nextLine());
        for (Product product : productList)
            if (product.getId() == id){
                product.setName(name);
                product.setPrice(price);
                System.out.println("Update thanh cong");
                System.out.println(product);
            }
    }


    public void delete() {
        display();
        System.out.print("Input id need delete: ");
        int id = Integer.parseInt(sc.nextLine());
        productList.remove(id);
        System.out.println("Remove thanh cong");
    }

    public void display(){
        for (Product product : productList)
            System.out.println(product + "\n");
    }

    public void search(){
        System.out.println("Input name need to search: ");
        String searchInputName = sc.nextLine();
        for (Product product : productList)
            if (product.getName().equals(searchInputName))
                System.out.println(product);
    }

    public void sortASC(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() > p2.getPrice())
                    return 1;
                else if (p1.getPrice() < p2.getPrice())
                    return -1;
                else
                    return 1;
            }
        });
    }
    public void sortDES(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                if (p1.getPrice() < p2.getPrice())
                    return 1;
                else if (p1.getPrice() > p2.getPrice())
                    return -1;
                else
                    return 1;
            }
        });
    }

}
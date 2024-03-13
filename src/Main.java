import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Product laDivinaCommedia = new Product(123456, "La Divina Commedia", "Books", 100.50);
        Product odissea = new Product(789123, "L'Odissea", "Books", 85.20);
        Product eneide = new Product(255284, "L'Eneide'", "Books", 105.45);
        Product iMalavoglia = new Product(745256, "I malavoglia", "Books", 87.60);

        Product culla = new Product(541568, "Culla", "Baby", 250.32);
        Product setDiBavette = new Product(741569, "Set di bavette", "Baby", 12.40);
        Product seggiolone = new Product(6541658, "Seggiolone", "Baby", 84.90);

        Product pallone = new Product(741256, "Pallone", "Boys", 15.90);
        Product racchetta = new Product(616584, "Racchetta", "Boys", 78.40);
        Product cappello = new Product(259114, "Cappellino", "Boys", 415.21);

        List<Product> productsList = new ArrayList<>();

        productsList.add(laDivinaCommedia);
        productsList.add(odissea);
        productsList.add(eneide);
        productsList.add(iMalavoglia);
        productsList.add(culla);
        productsList.add(setDiBavette);
        productsList.add(seggiolone);
        productsList.add(pallone);
        productsList.add(racchetta);
        productsList.add(cappello);


//        System.out.println("La lista ha " + productsList.size() + " elementi.");
//
//        for (Product product : productsList) {
//            System.out.println(product);
//        }

        System.out.println("----------------- LIBRI CHE COSTANO PIU' DI 100");


        List<Product> listalibri100 = productsList.stream()
                .filter(product -> "Books".equals(product.getCategory())&& product.getPrice() > 100)
                .toList();

        for (Product product : listalibri100) {
            System.out.println(product);
        }

        System.out.println("----------------- PRODOTTI CATEGORIA BABY");

        List<Product> listababy = productsList.stream()
                .filter(product -> "Baby".equals(product.getCategory()))
                .toList();

        for (Product product : listababy) {
            System.out.println(product);
        }

        System.out.println("----------------- PRODOTTI CATEGORIA BOYS SCONTATI AL 10%");

        List<Product> boysProducts = productsList.stream()
                .filter(product -> "Boys".equals(product.getCategory()))
                .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9;
                    return new Product(product.getId(), product.getName(), product.getCategory(), discountedPrice);
                })
                .toList();

        for (Product product : boysProducts) {
            System.out.println(product);
        }

        //        ESERCIZIO 4
        LocalDate date = LocalDate.parse("2021-02-02");
        LocalDate datee = LocalDate.parse("2021-03-02");
        LocalDate startDate = LocalDate.parse("2021-02-01");
        LocalDate endDate = LocalDate.parse("2021-04-01");

        Customer cliente = new Customer(613555,"Michela",4);
        Customer mariobros = new Customer(16885,"MarioBros",2);
        Customer luigibros = new Customer(56526,"LuigiBros",2);

        Order ilMioOrdine = new Order(14746958,"spedito", LocalDate.now(),LocalDate.now(),boysProducts,cliente);
        Order ordineMario = new Order(54586,"evaso",date,date,listababy,mariobros);
        Order ordineLuigi = new Order(45620,"evaso",datee,datee,listalibri100,luigibros);


        List<Order> orders = new ArrayList<>();
        orders.add(ilMioOrdine);
        orders.add(ordineMario);
        orders.add(ordineLuigi);

        
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .toList();


        System.out.println("Ordini effettuati da clienti di livello 2 tra il " + startDate + " e il " + endDate + ":");
        for (Order order : filteredOrders) {
            System.out.println(order);
        }
    }
    }






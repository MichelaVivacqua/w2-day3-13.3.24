import entities.Product;

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


        System.out.println("La lista ha " + productsList.size() + " elementi.");

        for (Product product : productsList) {
            System.out.println(product);
        }
        System.out.println("----------------- LIBRI CHE COSTANO PIU' DI 100");


        productsList.stream()
                .filter(product -> "Books".equals(product.getCategory()) && product.getPrice() > 100.0)
                .forEach(product -> System.out.println(product));

        System.out.println("----------------- PRODOTTI CATEGORIA BABY");

        productsList.stream()
                .filter(product ->"Baby".equals(product.getCategory()))
                .forEach(product -> System.out.println(product));

        System.out.println("----------------- PRODOTTI CATEGORIA BOYS SCONTATI AL 10%");

        productsList.stream()
                .filter(product ->"Baby".equals(product.getCategory()))
            .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9; // Applicazione del 10% di sconto
                    return new Product(product.getId(), product.getName(), product.getCategory(), discountedPrice);
                })

       .forEach(product -> System.out.println(product));
        }


    }


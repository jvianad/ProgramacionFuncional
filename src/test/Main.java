package test;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Arroz", 30.5, "Alimentos", 50));
        productList.add(new Product("Leche", 20.0, "Alimentos", 0));
        productList.add(new Product("Laptop", 1500.0, "Electrónicos", 10));
        productList.add(new Product("TV", 800.0, "Electrónicos", 5));
        productList.add(new Product("Mesa", 120.0, "Hogar", 15));

        /*Obtener una lista de todos los productos con stock mayor a 0 y con un precio menor a 50*/
        List<Product> filteredList = productList.stream()
                .filter(pd -> pd.getStock() > 0 && pd.getPrecio() < 50)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        System.out.println();

        /*Obtener la lista de nombres de todos los productos de la categoría "Alimentos"*/
        List<Product> filteredList2 = productList.stream()
                .filter(pd -> pd.getCategoria() == "Alimentos")
                .collect(Collectors.toList());
        filteredList2.forEach(pd -> System.out.println(pd.getNombre()));

        System.out.println();

        /*Obtener el precio total de todos los productos*/
        Function<List<Product>,Double> totalPrice = products -> {
            double subtotal = 0;
            for (Product pdt : products){
                subtotal += pdt.getPrecio();
            }
            return subtotal;
        };

        double finalTotalPrice = totalPrice.apply(productList);
        System.out.println("Total price from all products: "+finalTotalPrice);

    }
}

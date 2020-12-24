package springframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

            List<Product> productList = new ArrayList<Product>();

            productList.add(new Product(26,"ball","redball",100));
            productList.add(new Product(6,"table","browntable",3800));
            productList.add(new Product(234,"chair","plasticchair",1500));
            productList.add(new Product(65,"table","steeltable",70));
            productList.add(new Product(15,"bedsheet","cotton",1250));

        System.out.println("Before Sorting the product data:");
        //java 8 forEach for printing the list
        productList.forEach((product)->System.out.println(product));


        //lambda expression for sorting product by price in ascending order
        System.out.println("After sorting the product data by price in ascending order");
        productList.sort((Product product1, Product product2)-> (int)(product1.getPrice()-product2.getPrice()));
        System.out.println(productList);

        System.out.println("Sorting the product by price in descending order");
        productList.sort((Product product1,Product product2)->(int) (product2.getPrice()- product1.getPrice()));
        System.out.println(productList);

      //Sort all products by their name
      System.out.println("After sorting the product data by name");
      productList.sort(Comparator.comparing(product1 -> product1.getName()));
      productList.forEach((product -> System.out.println(product)));

      //another way to sort using comparators
      productList.sort((Product p1,Product p2)->p1.getName().compareTo(p2.getName()));

      productList.sort(Comparator.comparing(Product::getName));

        //Sort all products by name; And then reversed
        System.out.println("Sorting by name in reverse order");
        Comparator<Product> comparator = Comparator.comparing(product -> product.getName());
        productList.sort(comparator.reversed());
        System.out.println(productList);

        //multiple fileds
        System.out.println("Sorting by name first and then description" );
        productList.sort(Comparator.comparing(Product::getName).thenComparing(Product::getDescription));
        System.out.println(productList);

        //Another way to sort
        Comparator<Product> groupByComparator = Comparator.comparing(Product::getName)
               .thenComparing(Product::getDescription);
        //productList.sort(groupByComparator);
        //System.out.println(productList);

        //stream sort
        Comparator<Product> nameComparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
        List<Product> sortedProduct = productList.stream().sorted(nameComparator).collect(Collectors.toList());
        System.out.println(sortedProduct);

        List<Product> sortedProductList = productList.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        System.out.println(sortedProductList);

        //reverse order sorting using stream sort API
        System.out.println("Reverse order sorting using Stream sorted API");
        List<Product> reverseSortedProduct = productList.stream()
                .sorted(Comparator.comparing(Product::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(reverseSortedProduct);

        //Parallel Sorting
        Product[] productsArray = productList.toArray(new Product[productList.size()]);
        //Parallel sorting
        Arrays.parallelSort(productsArray, groupByComparator);
        System.out.println(productsArray);

    }
}

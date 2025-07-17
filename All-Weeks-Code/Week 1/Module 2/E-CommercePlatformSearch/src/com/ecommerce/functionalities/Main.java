package com.ecommerce.functionalities;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    	Product[] products = {
    		    new Product(101, "Laptop", "Electronics"),
    		    new Product(105, "Shoes", "Footwear"),
    		    new Product(102, "Phone", "Electronics"),
    		    new Product(107, "Watch", "Accessories"),
    		    new Product(109, "Backpack", "Bags"),
    		    new Product(103, "Headphones", "Electronics"),
    		    new Product(108, "T-shirt", "Clothing")
    		};


        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        Product found1 = LinearSearch.linearSearch(products, 103);
        Product found2 = LinearSearch.linearSearch(products, 104);
        Product found3 = BinarySearch.binarySearch(sortedProducts, 107);
        Product found4 = BinarySearch.binarySearch(sortedProducts, 106);

        System.out.println(found1 != null ? "Linear: Found " + found1.toString() : "Linear: Not Found");
        System.out.println(found2 != null ? "Linear: Found " + found2.toString() : "Linear: Not Found");
        System.out.println(found3 != null ? "Binary: Found " + found3.toString() : "Binary: Not Found");
        System.out.println(found4 != null ? "Binary: Found " + found4.toString() : "Binary: Not Found");
    }
}


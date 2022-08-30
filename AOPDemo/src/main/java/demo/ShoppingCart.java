package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    
    public void checkout(String status){
        // Logging
        // Authentication and Authorization
        // Sanitization

        // All the things above are cross cutting concerns that we want to seperate out, while below in the business logic
        System.out.println("Checkout Method from ShoppingCart Called");
    }

    public int quantity(){
        return 2;
    }
}

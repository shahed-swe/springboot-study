package demo;
import org.springframework.stereotype.Component;

@Component

public class ShoppingCart {

    public void checkout(){
//        Logging
//        Authentication
//        Authorization
//        Sanitization

        System.out.println("Checkout method from ShoppingCart Called");
    }

    public void checking(String check){
        System.out.println("Checking int "+ check);
    }

    public String published(String name){
        System.out.println("Published method from ShoppingCart Called");
        return name + " Are comming to you";
    }


    public int quantity(){
        return 2;
    }
}

package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);


        ShoppingCart cart = context.getBean(ShoppingCart.class);
//        cart.checkout();
//        cart.checking("Checking In New Things");
//        cart.published("Name New Things");
        cart.quantity();


    }

}

package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    @Before("execution(* demo.ShoppingCart.checkout())")
    public void logger(){
        System.out.println("Logger is logging to log");
    }


    @After("execution(* *.*.checking(..))")
    public void checkingLogger(JoinPoint jp){
        String ares = jp.getArgs()[0].toString();
        System.out.println("Argument Getting: "+ ares);
    }

    @AfterReturning(pointcut = "execution(* *.*.published(..))", returning = "name")
    @Async
    public void loggernew(JoinPoint jp, String name){

        System.out.println("signature"+jp.getArgs()[0]);
        System.out.println("This is calling after the function published");
        System.out.println(name);
    }

    @Pointcut("execution(* *.*.quantity(..))")
    public void afterReturningPointCut(){

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(int retVal){
        System.out.println("After Return: "+ retVal);
    }


//    point cut is so sensitive to use. always follow return type


//    @AfterReturning -> this called after a function return a value
//    @AfterThrowing -> this called after a function through a value
}


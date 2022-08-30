package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // mark it as an aspect
@Component
public class LoggingAspect {
    // first * means any return type, * in the method call just means any package/case wtc. with that method

    // must include .. in the method call to take into account the parameters

    @Before("execution(* demo.ShoppingCart.checkout(..))")  //defining when you want this aspect to run, In this case before the execution of the specific method
    public void beforeLogger(JoinPoint jp){
        //System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();  // This is how we would get the arguments passed to the function, they are all returned as an array
        System.out.println("Loggers with arg " + arg);
    }

    @After("execution(* *.*.checkout(..))")  //this aspect will run after the execution of checkout methods
    public void afterLogger(){
        System.out.println("ALoggers");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturnPointCut(){}

    @AfterReturning(pointcut = "afterReturnPointCut()", returning = "retVal") // done at the pointcut defined and puts the return value into the variable defined
    public void afterReturn(String retVal){
        System.out.println("After Returning " + retVal);
    }
}

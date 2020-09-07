package com.xzy.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类，方法是通知方法
 */
@Aspect
@Component
public class LogUtils {
    /**
     * 切入点表达式的写法：
     * 固定格式：execution(访问修饰符  返回值类型  方法全签名 (参数类型))
     * 通配符：*
     * 匹配一个或多个字符
     * 匹配一个参数
     * 匹配一层路径
     * ..
     * 匹配任意类型的多个参数
     * 匹配任意多层路径
     * <p>
     * 还可以将多个表达式用&& ||  !  来连接进行逻辑判断（了解即可）
     * <p>
     * 通知方法的执行顺序
     * 正常执行
     * @Before 前置通知 --> @After后置通知 --> @AfterReturning 返回
     * <p>
     * 异常执行
     * @Before 前置通知 --> @After后置通知 --> @AfterThrowing  异常
     */

    //目标方法之前运行
    //要写切入点表达式
    @Before("execution(public int com.xzy.impl.CalculatorImpl.*(int,int))")
    public static void logStart(JoinPoint joinPoint) {
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        //获取方法名
        String name = signature.getName();
        System.out.println("【" + name + "】方法开始执行，参数是：【" + Arrays.asList(joinPoint.getArgs()) + "】");
    }

    //目标方法返回时运行
    //returning指定那个参数接收返回值
    @AfterReturning(value = "execution(public int com.xzy.impl.CalculatorImpl.*(int,int))",
            returning ="result" )
    public static void logReturn(JoinPoint joinPoint,Object result) {
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法正常返回，返回值是：【"+result+"】");
    }

    //目标方法出现异常运行
    //通过throwing指定那个参数接收异常
    @AfterThrowing(value = "execution(public int com.xzy.impl.CalculatorImpl.div(int,int))",
    throwing = "exception")
    public static void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法出现异常，异常信息是：【"+exception+"】");
    }

    //目标方法运行结束之后运行
    @After("execution(public int com.xzy.impl.CalculatorImpl.*(int,int))")
    public static void logEnd(JoinPoint joinPoint) {
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法正常结束");
    }
    @Around("execution(public int com.xzy.impl.CalculatorImpl.*(int,int))")
    public static Object LogAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        //利用反射调用目标方法
        Object proceed = null;
        try {
            //此处为环绕前置通知
            proceed = pjp.proceed(args);//目标方法
            //此处为环绕返回通知
        } catch (Throwable throwable) {
            //此处为环绕出现异常通知
        } finally {
            //环绕后置通知
        }
        System.out.println("环绕通知。。。。");
        return proceed;
    }
}

package utilities;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import pages.MyAnnotation;

@Aspect
public class Aspects {

    /**
     * Around annotation
     *
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(io.cucumber.java.en.Given)")
    public Object annotation(ProceedingJoinPoint jp) throws Throwable {
//        MergedAnnotations mergedAnnotations = MergedAnnotations.from(jp.getThis());
        Object obj = jp.proceed();
        System.out.println("nir");
        return obj;
    }

    /**
     * Around method
     *
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("execution(* steps.Hooks.enableNetwork(..))")
    public Object method(ProceedingJoinPoint jp) throws Throwable {
        MyAnnotation myAnnotation = ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(MyAnnotation.class);
        String value = myAnnotation.value();
        Object obj = jp.proceed();
        System.out.println("nir");
        return obj;
    }
}

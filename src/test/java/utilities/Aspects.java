package utilities;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.MergedAnnotations;

@Aspect
public class Aspects {

    @Around("@annotation(io.cucumber.java.en.Given)")
    public Object auditMethod(ProceedingJoinPoint jp) throws Throwable {
//        MergedAnnotations mergedAnnotations = MergedAnnotations.from(jp.getThis());
Object obj = jp.proceed();
        System.out.println("nir");
        return obj;
    }
}

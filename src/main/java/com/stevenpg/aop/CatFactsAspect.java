package com.stevenpg.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Aspect
@Component
public class CatFactsAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(CatFacts)")
    public Object displayCatFact(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object proceed = joinPoint.proceed();
        List<String> catFacts = new ArrayList<>();
        Random rand = new Random();
        int catFactIndex = rand.nextInt(10) + 1;

        catFacts.add("1. Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.");
        catFacts.add("2. There are cats who have survived falls from over 32 stories (320 meters) onto concrete.");
        catFacts.add("3. A group of cats is called a clowder.");
        catFacts.add("4. Cats have over 20 muscles that control their ears.");
        catFacts.add("5. Cats sleep 70% of their lives.");
        catFacts.add("6. A cat has been mayor of Talkeetna, Alaska, for 15 years. His name is Stubbs.");
        catFacts.add("7. And one ran for mayor of Mexico City in 2013.");
        catFacts.add("8. In tigers and tabbies, the middle of the tongue is covered in backward-pointing spines, used for breaking off and gripping meat.");
        catFacts.add("9. When cats grimace, they are usually \"taste-scenting.\" They have an extra organ that, with some breathing control, allows the cats to taste-sense the air.");
        catFacts.add("10. Cats can't taste sweetness.");

        logger.info("test");
        System.out.println(catFacts.get(catFactIndex));
        return proceed;
    }
}

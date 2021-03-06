package com.stevenpg.catfacts;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Aspect
@Component
public class CatFactsAspect {

    private Random rand = new Random();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<String> catFacts = Arrays.asList(
            "1. Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.",
            "2. There are cats who have survived falls from over 32 stories (320 meters) onto concrete.",
            "3. A group of cats is called a clowder.",
            "4. Cats have over 20 muscles that control their ears.",
            "5. Cats sleep 70% of their lives.",
            "6. A cat has been mayor of Talkeetna, Alaska, for 15 years. His name is Stubbs.",
            "7. And one ran for mayor of Mexico City in 2013.",
            "8. In tigers and tabbies, the middle of the tongue is covered in backward-pointing spines, used for breaking off and gripping meat.",
            "9. When cats grimace, they are usually \"taste-scenting.\" They have an extra organ that, with some breathing control, allows the cats to taste-sense the air.",
            "10. Cats can't taste sweetness.",
            "11. Owning a cat can reduce the risk of stroke and heart attack by a third.",
            "12. Wikipedia has a recording of a cat meowing because why not?",
            "13. The world's largest cat measured 48.5 inches long.",
            "14. Evidence suggests domesticated cats have been around since 3600 B.C., 2,000 years before Egypt's pharaohs.",
            "15. A cat's purr may be a form of self-healing, as it can be a sign of nervousness as well as contentment.",
            "16. Similarly, the frequency of a domestic cat's purr is the same at which muscles and bones repair themselves.",
            "17. Adult cats only meow to communicate with humans.",
            "18. The world's richest cat is worth $13 million after his human passed away and left her fortune to him.",
            "19. Your cat recognizes your voice but just acts too cool to care (probably because they are).",
            "20. Cats are often lactose intolerant, so stop givin' them milk!",
            "21. Basically all cartoon cats lied to us: Raw fish is off the table for cats as well.",
            "22. The oldest cat video on YouTube dates back to 1894 (when it was made, not when it was uploaded, duh).",
            "23. In the 1960s, the CIA tried to turn a cat into a bonafide spy by implanting a microphone into her ear and a radio transmitter at the base of her skull. She somehow survived the surgery but got hit by a taxi on her first mission.",
            "24. The technical term for \"hairball\" is \"bezoar.\"",
            "25. Female cats are typically right-pawed while male cats are typically left-pawed.",
            "26. Cats make more than 100 different sounds whereas dogs make around 10.",
            "27. A cat's brain is 90% similar to a human's — more similar than to a dog's.",
            "28. Cats and humans have nearly identical sections of the brain that control emotion.",
            "29. A cat's cerebral cortex (the part of the brain in charge of cognitive information processing) has 300 million neurons, compared with a dog's 160 million.",
            "30. Cats have a longer-term memory than dogs, especially when they learn by actually doing rather than simply seeing.",
            "31. Basically, cats have a lower social IQ than dogs but can solve more difficult cognitive problems when they feel like it.",
            "32. Cats have 1,000 times more data storage than an iPad.",
            "33. It was illegal to slay cats in ancient Egypt, in large part because they provided the great service of controlling the rat population.",
            "34. In the 15th century, Pope Innocent VIII began ordering the killing of cats, pronouncing them demonic.",
            "35. A cat has five toes on his front paws, and four on the back, unless he's a polydactyl.",
            "36. Polydactyl cats are also referred to as \"Hemingway cats\" because the author was so fond of them.",
            "37. There are 45 Hemingway cats living at the author's former home in Key West, Fla.",
            "38. Original kitty litter was made out of sand but it was replaced by more absorbent clay in 1948.",
            "39. Abraham Lincoln kept four cats in the White House.",
            "40. When asked if her husband had any hobbies, Mary Todd Lincoln is said to have replied \"cats.\"",
            "41. Isaac Newton is credited with inventing the cat door.",
            "42. One legend claims that cats were created when a lion on Noah's Ark sneezed and two kittens came out.",
            "43. A cat can jump up to six times its length.",
            "44. A house cat is faster than Usain Bolt.",
            "45. When cats leave their poop uncovered, it is a sign of aggression to let you know they don't fear you.",
            "46. Cats can change their meow to manipulate a human. They often imitate a human baby when they need food, for example.",
            "47. Cats use their whiskers to detect if they can fit through a space.",
            "48. Cats only sweat through their foot pads.",
            "49. The first cat in space was French. She was named Felicette, or \"Astrocat.\" She survived the trip.",
            "50. Cats have free-floating clavicle bones that attach their shoulders to their forelimbs, which allows them to squeeze through very small spaces.",
            "51. Hearing is the strongest of cat's senses: They can hear sounds as high as 64 kHz — compared with humans, who can hear only as high as 20 kHz.",
            "52. Cats can move their ears 180 degrees.",
            "53. They can also move their ears separately.",
            "54. A cat has detected his human's breast cancer.",
            "55. A cat's nose is ridged with a unique pattern, just like a human fingerprint.",
            "56. Cats have scent glands along their tail, their forehead, lips, chin, and the underside of their front paws.",
            "57. A cat rubs against people to mark its territory.",
            "58. Cats lick themselves to get your scent off.",
            "59. When a family cat died in ancient Egypt, family members would shave off their eyebrows as they mourned.",
            "60. They also had elaborate memorials that included mummifying the cat and either burying it in a family tomb or pet cemetery.",
            "61. Cats were mythic symbols of divinity in ancient Egypt.",
            "62. Black cats are bad luck in the United States, but they are good luck in the United Kingdom and Australia.",
            "63. Most cats don't like water because their coats do not insulate them well enough.",
            "64. However, a cat called the Turkish Van does not have that insulation problem and LOVES it.",
            "65. The Egyptian Mau is the oldest breed of cat.",
            "66. This breed is also the fastest pedigreed cat.",
            "67. The Egyptian word for cat is, in fact, \"mau.\"",
            "68. Only 11.5% of people consider themselves \"cat people.",
            "69. Cat people are also 11% more likely to be introverted.",
            "70. Still, cat people are more open to new experiences than typical \"dog people.\"",
            "71. Cat owners who are male tend to be luckier in love, as they are perceived as more sensitive.",
            "72. Cat owners are 17% more likely to have a graduate degree.",
            "73. Cat people are 25% likely to pick George as their favorite Beatle.",
            "74. A cat's carbon footprint is similar to that of a VW Bug, whereas a dog's is more like a Hummer.",
            "75. When your cat brings home a dead mouse or bird, it may do so to show you that you suck at hunting.",
            "76. Cats have inferior daytime sight, but during the night they need seven times less light than humans to see.",
            "77. The largest litter of kittens produced 19 kittens.",
            "78. Eighty-eight percent of cats in the U.S. are spayed or neutered.",
            "79. Only 24% of cats who enter animal shelters are adopted.",
            "80. Cats are really cool."
    );

    @Around("@annotation(CatFacts)")
    public Object displayCatFact(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object proceed = joinPoint.proceed();
        int catFactIndex = rand.nextInt(81) + 1;
        logger.info(catFacts.get(catFactIndex));
        return proceed;
    }
}

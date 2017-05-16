package ISA.IT;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {

        CountDownLatch dependency1_2 = new CountDownLatch(1);

        CountDownLatch dependency2_5 = new CountDownLatch(1);

        CountDownLatch dependency5_3 = new CountDownLatch(1);

        CountDownLatch dependency6_4 = new CountDownLatch(1);

        CountDownLatch dependency4_7 = new CountDownLatch(1);

        CountDownLatch dependency7_3 = new CountDownLatch(1);

//1

        new Activity(Optional.of(() -> System.out.println("Action in 1")),Optional.empty(),Optional.of(dependency1_2)).start();

//2

        new Activity(Optional.of(() -> System.out.println("Action in 2")),Optional.of(dependency1_2),Optional.of(dependency2_5)).start();

//5

        new Activity(Optional.of(() -> System.out.println("Action in 5")),Optional.of(dependency2_5),Optional.of(dependency5_3)).start();

//6

        new Activity(Optional.of(() -> System.out.println("Action in 6")),Optional.of(dependency5_3),Optional.of(dependency6_4)).start();

//4

        new Activity(Optional.of(() -> System.out.println("Action in 4")),Optional.of(dependency6_4),Optional.of(dependency4_7)).start();

//7

        new Activity(Optional.of(() -> System.out.println("Action in 7")),Optional.of(dependency4_7),Optional.of(dependency7_3)).start();

//3

        new Activity(Optional.of(() -> System.out.println("Action in 3")),Optional.of(dependency7_3),Optional.empty()).start();

    }
}

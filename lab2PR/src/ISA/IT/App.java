package ISA.IT;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {

        CountDownLatch dependency = new CountDownLatch(2);

//3

        new Activity(Optional.of(() -> System.out.println("Action in 3")),Optional.of(dependency),Optional.empty()).start();

//6

        new Activity(Optional.of(() -> System.out.println("Action in 6")),Optional.of(dependency),Optional.empty()).start();

//4

        new Activity(Optional.of(() -> System.out.println("Action in 4")),Optional.of(dependency),Optional.empty()).start();

//7

        new Activity(Optional.of(() -> System.out.println("Action in 7")),Optional.of(dependency),Optional.empty()).start();

//1

        new Activity(Optional.of(() -> System.out.println("Action in 1")),Optional.empty(),Optional.of(dependency)).start();

//2

        new Activity(Optional.of(() -> System.out.println("Action in 2")),Optional.empty(),Optional.of(dependency)).start();

//5

        new Activity(Optional.of(() -> System.out.println("Action in 5")),Optional.empty(),Optional.of(dependency)).start();


    }
}

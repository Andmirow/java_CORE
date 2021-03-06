package main.com.company.threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4 ;
    public static String winner;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    public static Lock lock = new ReentrantLock();
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT+1);
    public static void main (String[] args) {
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!" );

        Race race = new Race( new Road( 60 ), new Tunnel(), new Road( 40 ));
        Car[] cars = new Car[CARS_COUNT];
        for ( int i = 0 ; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + ( int ) (Math.random() * 10 ));
        }
        for ( int i = 0 ; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!" );

        try {
            cdlFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println( "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!" );
            System.out.println("Поздравим победителя это " + winner);
    }
}

package Misc;

import java.util.Arrays;

public class Animal {

    public static void main(String[] args) {
//        int [] arr = {5, 3, 8 ,2 , 7};
//
//        Arrays.sort(arr);
//
//        int result = Arrays.binarySearch(arr, 5);
//        System.out.print(result);



        Animal animal = new Animal();
        Thread t1 = new Thread(() -> {
            try {
                animal.printOne(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                animal.printTwo(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                animal.printThree(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private synchronized void printOne(int n) throws InterruptedException {
        System.out.println("Thread "+ Thread.currentThread()+ " Multiple of printOne");

        for(int i = 1; i <= n ; i++){
            if(i%3 != 1){
                wait();
            }
            System.out.println(" Number = "+ i);

            notifyAll();
        }
    }


    public synchronized  void printTwo(int n) throws InterruptedException {
        System.out.println("Thread "+ Thread.currentThread()+ " Multiple of printTwo");

        for(int i = 1; i <= n ; i++){
            if(i%3 != 2){
                wait();
            }
            System.out.println(" Number = "+ i);

            notifyAll();
        }
    }

    public synchronized void printThree(int n) throws InterruptedException {
        System.out.println("Thread "+ Thread.currentThread()+ " Multiple of printThree");

        for(int i = 1; i <= n ; i++){
            if(i%3 != 0){
                wait();
            }
            System.out.println(" Number = "+ i);

            notifyAll();
        }
    }
}


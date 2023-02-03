package com.javarush.task.task16.task1615;

public class Test {
    private static volatile RunWay runWay = new RunWay();

    public static void main(String[] args) {
        Plane plane1 = new Plane("Plane №1");
        Plane plane2 = new Plane("Plane №2");
        Plane plane3 = new Plane("Plane №3");
    }

    public static void waiting () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void takingOff () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Plane extends Thread {
        public Plane (String name) {
            super(name);
            start();
        }
        @Override
        public void run () {
            boolean ready = false;
            while (!ready) {
                if (runWay.tryToSetPlane(this)) {
                    System.out.println(this.getName() + " is taking off");
                    takingOff();
                    System.out.println(this.getName() + " is flying");
                    ready = true;
                    runWay.setPlane(null);
                } else {
                    System.out.println(this.getName() + " is waiting...");
                    waiting();
                }
            }


        }

    }

    public static class RunWay {
        private Thread thread;

        public void setPlane (Thread thread) {
            synchronized (this) {
                this.thread = thread;
            }
        }

        public Thread getPlane () {
            synchronized (this) {
                return this.thread;
            }
        }

        public boolean tryToSetPlane (Thread thread) {
            synchronized (this) {
                if (this.thread == null) {
                    this.thread = thread;
                    return true;
                } else return false;
            }
        }



    }
}

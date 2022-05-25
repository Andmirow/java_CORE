package main.com.company.threadTest;

public class Road extends Stage{
    public Road ( int length) {
        this .length = length;
        this .description = "Дорога " + length + " метров" ;
    }
    @Override
    public void go (Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            MainClass.cdlFinish.countDown();
            MainClass.winner = c.getName();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

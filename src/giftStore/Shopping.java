package giftStore;

import java.util.concurrent.CountDownLatch;

public class Shopping {
    public static Store store = new Store();

    public static void main(String[] args) {
        store.showGifts();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("-----------------用户信息-----------------");
        new Thread(new Member("m001", 100000, store, countDownLatch)).start();
        new Thread(new Member("m002", 100000, store, countDownLatch)).start();
        new Thread(new Member("m003", 100000, store, countDownLatch)).start();
        new Thread(new Member("m004", 100000, store, countDownLatch)).start();
        new Thread(new Member("m005", 100000, store, countDownLatch)).start();
        try {
            countDownLatch.await();     //阻塞主线程执行，直至子线程都执行结束
            System.out.println("\n客户都花光了手里的钱\n");
            store.showGifts();
            System.out.println("--------------交易次数校验---------------");
            System.out.println("本次共产生" + store.getAccountBook().size() + "次交易");
            System.out.println("礼品实际卖出" + store.salesAmount() + "件");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

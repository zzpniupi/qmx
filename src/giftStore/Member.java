package giftStore;

import java.util.concurrent.CountDownLatch;

public class Member implements Runnable {
    private String memberID;
    private int money;      //用户积分余额
    private Store store;
    public CountDownLatch countDownLatch;

    @Override
    public void run() {
        showMeberInfo();
        buyGift(store);
        countDownLatch.countDown();
    }

    public Member(String memberID, int money, Store store, CountDownLatch countDownLatch) {
        this.memberID = memberID;
        this.money = money;
        this.store = store;
        this.countDownLatch = countDownLatch;
    }

    public void buyGift(Store store) {
        Gift[] gifts = store.getGifts();
        while (money > 0) {
            int giftType = (int) (Math.random() * 10);
            Gift gift = gifts[giftType];
            //处理没钱买或者没礼品库存的情况
            if (!hasMoney(gift) || !gift.hasGift())
                continue;
            //需要处理同步问题
            //减少礼品剩余数量
            gift.buyGift();
            //扣除会员积分  单线程访问money可以不同步
            money -= gift.getGiftPrice();
            //记账
            PurchaseRecord record = new PurchaseRecord(gift, this);
//            record.showPurchaseRecord();
            store.keepAccounts(record);
            //展示实时信息
//            gift.showGiftInfo();
//            this.showMeberInfo();
        }
//        store.showAccountBook();
    }

    public boolean hasMoney(Gift gift) {
        if (this.money < gift.getGiftPrice())
            return false;
        else
            return true;
    }

    public void showMeberInfo() {
        System.out.println("用户编号是： " + memberID + "---用户剩余积分： " + money);
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}

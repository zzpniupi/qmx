package giftStore;

import java.util.LinkedList;
import java.util.List;

public class Store {
    private Gift[] gifts = new Gift[10];
    private List<PurchaseRecord> accountBook = new LinkedList<>();      //账本

    public Store() {
        gifts[0] = new Gift("1001", "一号礼物", 20000, 1);
        gifts[1] = new Gift("1002", "二号礼物", 20000, 2);
        gifts[2] = new Gift("1003", "三号礼物", 20000, 3);
        gifts[3] = new Gift("1004", "四号礼物", 20000, 4);
        gifts[4] = new Gift("1005", "五号礼物", 20000, 5);
        gifts[5] = new Gift("1006", "六号礼物", 20000, 6);
        gifts[6] = new Gift("1007", "七号礼物", 20000, 7);
        gifts[7] = new Gift("1008", "八号礼物", 20000, 8);
        gifts[8] = new Gift("1009", "九号礼物", 20000, 9);
        gifts[9] = new Gift("1010", "十号礼物", 20000, 10);
    }

    public Gift[] getGifts() {
        return gifts;
    }

    public synchronized void keepAccounts(PurchaseRecord record){
        accountBook.add(record);
    }

    public void showAccountBook(){
        for(PurchaseRecord record:accountBook){
            record.showPurchaseRecord();
        }
    }

    public void showGifts() {
        System.out.println("----------------------------小招礼品屋礼品信息----------------------------");
        for (Gift gift : gifts) {
            gift.showGiftInfo();
        }
    }
}

package giftStore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseRecord {
    private Gift gift;
    private Member member;
    private String date;

    public PurchaseRecord(Gift gift, Member member) {
        this.gift = gift;
        this.member = member;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = sdf.format(new Date());
    }

    public void showPurchaseRecord(){
        System.out.println("用户"+member.getMemberID()+"于"+date+"购买了"+gift.getGiftDescription());
    }

}

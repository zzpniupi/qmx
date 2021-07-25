package giftStore;

public class Gift {
    private String giftID;
    private String giftDescription;
    private int giftNum;
    private int giftPrice;      //礼品积分

    public Gift(String giftID, String giftDescription, int giftNum, int giftPrice) {
        this.giftID = giftID;
        this.giftDescription = giftDescription;
        this.giftNum = giftNum;
        this.giftPrice = giftPrice;
    }

    public void showGiftInfo() {
        System.out.println("礼品编号: " + giftID + "---礼品信息: " + giftDescription + "---礼品剩余数量: " + giftNum + "---礼品价格: " + giftPrice);
    }

    public synchronized void buyGift() {
        giftNum--;
    }

    public boolean hasGift() {
        if (giftNum > 0)
            return true;
        else
            return false;
    }

    public String getGiftID() {
        return giftID;
    }

    public void setGiftID(String giftID) {
        this.giftID = giftID;
    }

    public String getGiftDescription() {
        return giftDescription;
    }

    public void setGiftDescription(String giftDescription) {
        this.giftDescription = giftDescription;
    }

    public int getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(int giftNum) {
        this.giftNum = giftNum;
    }

    public int getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(int giftPrice) {
        this.giftPrice = giftPrice;
    }
}

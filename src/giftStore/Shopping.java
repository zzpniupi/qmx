package giftStore;

public class Shopping {
    public static Store store = new Store();

    public static void main(String[] args) {
        store.showGifts();
        new Thread(new Member("m001",10000,store)).start();
        new Thread(new Member("m002",20000,store)).start();
        new Thread(new Member("m003",30000,store)).start();
        new Thread(new Member("m004",40000,store)).start();
        new Thread(new Member("m005",50000,store)).start();
    }
}

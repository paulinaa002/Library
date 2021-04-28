package library.publication;

import library.Publication;

public class Magazine extends Publication {

    private int releaseNo;
    private double price;
   // private final int oldReleaseNo = 13;


    public Magazine(){
        super();
    }

    public Magazine(int releaseNo){
        super();
        this.releaseNo = releaseNo;
        this.price = price;
    }

    public Magazine(String author, String title, int identificationNumber, int publicationDate, boolean isAvailable, int releaseNo, double price){
        super(author, title, identificationNumber, publicationDate, isAvailable);
        this.releaseNo = releaseNo;
        this.price = price;
    }


    public void setReleaseNo(int releaseNo) { this.releaseNo = releaseNo; }
    public void setPrice(double price) { this.price = price; }

    public int getReleaseNo() { return releaseNo; }
    public double getPrice() { return price; }


    public void sellMagazine(){

    }


    @Override
    public void takePublication(){

    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\nrelease no: " + releaseNo +
                "\nis in library: " + getAvailable() +
                "\nits price: " + price;
    }


    @Override
    public void clearData(){
        super.clearData();
        releaseNo = -1;
        price = -1;
    }

}

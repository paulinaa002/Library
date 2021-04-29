package library.publication;

import library.Publication;

import java.util.Calendar;
import java.util.Date;

public class Magazine extends Publication {

    private int releaseNo;


    public Magazine(){
        super();
    }

    public Magazine(int releaseNo){
        super();
        this.releaseNo = releaseNo;
    }

    public Magazine(String author, String title, int identificationNumber, int publicationDate, boolean isAvailable, int releaseNo){
        super(author, title, identificationNumber, publicationDate, isAvailable);
        this.releaseNo = releaseNo;
    }


    public void setReleaseNo(int releaseNo) { this.releaseNo = releaseNo; }

    public int getReleaseNo() { return releaseNo; }


    public void sellMagazine(){
    }


    @Override
    public void takePublication(){
        super.takePublication();
        Calendar dateNow = Calendar.getInstance();
        dateNow.setTime(todayDate);
        dateNow.add(Calendar.MONTH, +3);
        todayDate = dateNow.getTime();
    }


    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\nrelease no: " + releaseNo +
                "\nis in library: " + getAvailable();
    }


    @Override
    public void clearData(){
        super.clearData();
        releaseNo = -1;
    }

}

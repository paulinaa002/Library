package library.publication.magazine;

import library.publication.Publication;

import java.util.Calendar;
import java.util.Date;


public class Magazine extends Publication  {

    private int releaseNo;


    public Magazine(){
        super();
    }

    public Magazine(int releaseNo){
        super();
        this.releaseNo = releaseNo;
    }

    public Magazine(String author, String title, int identificationNumber, int publicationDate, int releaseNo){
        super(author, title, identificationNumber, publicationDate);
        this.releaseNo = releaseNo;
    }


    public void setReleaseNo(int releaseNo) { this.releaseNo = releaseNo; }

    public int getReleaseNo() { return releaseNo; }


    @Override
    public void takePublication() {
        if(getAvailable()) {
            todayDate = new Date();
            setAvailable(false);
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(todayDate);
            tempDate.add(Calendar.MONTH, +1);
            setDueDate(tempDate.getTime());
        }
    }

    @Override
    public String checkReturnDate() {
        return "Return until: " + getDueDate();
    }

    @Override
    public void returnPublication() {
            setDueDate(null);
            setAvailable(true);
    }

    @Override
    public void extendDueDate() {
        Calendar tempDate = Calendar.getInstance();
        tempDate.setTime(getDueDate());
        tempDate.add(Calendar.MONTH, +3);
        setDueDate(tempDate.getTime());
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\ngenre: " + releaseNo;
    }
}

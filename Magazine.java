package library.publication.magazine;

import library.publication.*;

import java.util.Calendar;
import java.util.Date;


public class Magazine extends Publication implements Cloneable {

    private int releaseNo;


    public Magazine(){

        super();
    }

    public Magazine(int releaseNo) {
        super();
        this.releaseNo = releaseNo;
    }

    public Magazine(String author, String title, int identificationNumber, int publicationDate, int releaseNo) {
        super(author, title, identificationNumber, publicationDate);
        this.releaseNo = releaseNo;
    }


    public void setReleaseNo(int releaseNo) { this.releaseNo = releaseNo; }

    public int getReleaseNo() { return releaseNo; }


    @Override
    public void takePublication() throws PublicationAvailabilityException {
        if(getAvailable()) {
            super.takePublication();
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(todayDate);
            tempDate.add(Calendar.MONTH, +3);
            setDueDate(tempDate.getTime());
        }
        else{
            throw new PublicationAvailabilityException(this, "Magazine is not available", getAvailable());
        }
    }



    @Override
    public void extendDueDate(int amount) throws PublicationException {
        if(getAvailable()){
            throw new PublicationAvailabilityException(this, "Magazine is not taken", getAvailable());
        }else if(amount > 12){
            throw new PublicationException(this, "Extension time too long");
        }else {
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(getDueDate());
            tempDate.add(Calendar.MONTH, +amount);
            setDueDate(tempDate.getTime());
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\nrelease no: " + releaseNo;
    }

    @Override
    public Magazine clone(){

        return (Magazine) super.clone();
    }


}

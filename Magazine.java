package library.publication.magazine;

import library.LibraryException;
import library.publication.Publication;
import library.publication.PublicationIssueDateException;
import library.publication.PublicationNotAvailableException;

import java.util.Calendar;
import java.util.Date;


public class Magazine extends Publication implements Cloneable {

    private int releaseNo;


    public Magazine(){

        super();
    }

    public Magazine(int releaseNo) throws LibraryException {
        super();
        this.releaseNo = releaseNo;
    }

    public Magazine(String author, String title, int identificationNumber, int publicationDate, int releaseNo) throws LibraryException {
        super(author, title, identificationNumber, publicationDate);
        year = Calendar.getInstance().get(Calendar.YEAR);
        if(publicationDate > year)
            throw new PublicationIssueDateException(this, "Publication is not released yet.", new Date());
        this.releaseNo = releaseNo;
    }


    public void setReleaseNo(int releaseNo) { this.releaseNo = releaseNo; }

    public int getReleaseNo() { return releaseNo; }


    @Override
    public void takePublication() throws PublicationNotAvailableException {
        if(getAvailable()) {
            super.takePublication();
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(todayDate);
            tempDate.add(Calendar.MONTH, +3);
            setDueDate(tempDate.getTime());
        }
        else{
            throw new PublicationNotAvailableException(this, "Magazine is not available");
        }
    }



    @Override
    public void extendDueDate() {
        Calendar tempDate = Calendar.getInstance();
        tempDate.setTime(getDueDate());
        tempDate.add(Calendar.MONTH, +2);
        setDueDate(tempDate.getTime());
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

    public Magazine clone() {
        Magazine cloned = null;
        try{
             cloned = (Magazine) super.clone();
        } catch (CloneNotSupportedException exc){
            exc.printStackTrace();
        }
        cloned.releaseNo = this.releaseNo;
        return cloned;
    }
}

package library;


import java.util.Calendar;
import java.util.Date;

public class Publication {

    private String author;
    private String title;
    private int identificationNumber;
    private int publicationDate;
    private boolean isAvailable = false;


    public Publication(){
        this(new String(), new String());
    }

    public Publication(String author, String title){
        this.author = author;
        this.title = title;
    }

    public Publication(String author, String title, int identificationNumber, int publicationDate, boolean isAvailable){
        this.author = author;
        this.title = title;
        this.identificationNumber = identificationNumber;
        this.publicationDate = publicationDate;
        this.isAvailable = isAvailable;
    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public int getIdentificationNumber() { return identificationNumber; }
    public int getPublicationDate() { return publicationDate; }
    public boolean getAvailable() { return isAvailable; }



    public final void setAuthor(String author) { this.author = author; }
    public final void setTitle (String title) { this.title = title; }
    public final void setIdentificationNumber (int ID) { identificationNumber = ID; }
    public final void setPublicationDate (int publicationDate) { this.publicationDate = publicationDate; }
    public void setAvailable (boolean isAvailable) { this.isAvailable = isAvailable; }

    public void takePublication(){    //void,String??
        if(isAvailable) {
            //some code

            setAvailable(false);
        }
    }

    public void clearData(){
        author = "";
        title = "";
        identificationNumber = -1;
        publicationDate = -1;
        isAvailable = false;
    }

    public void setData(String author1, String title1) {
        author = author1;
        title = title1;
    }


    @Override
    public String toString(){
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate();
    }
}

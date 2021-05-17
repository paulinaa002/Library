package library.publication;

import java.util.Calendar;
import java.util.Date;

public abstract class Publication implements TakeableWithProlong, Cloneable {

    private String author;
    private String title;
    private int identificationNumber;
    private int publicationDate;
    private boolean isAvailable = true;
    public Date todayDate;
    private Date dueDate;
    public int year;


    public Publication() { this(new String(), new String()); }

    public Publication(String author, String title)  {
        this.author = author;
        this.title = title;
    }

    public Publication(String author, String title, int identificationNumber, int publicationDate){
        this.author = author;
        this.title = title;
        this.identificationNumber = identificationNumber;
        this.publicationDate = publicationDate;
    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public int getIdentificationNumber() { return identificationNumber; }
    public int getPublicationDate() { return publicationDate; }
    public boolean getAvailable() { return isAvailable; }
    public Date getDueDate() { return dueDate; }


    public final void setAuthor(String author) { this.author = author; }
    public final void setTitle (String title) { this.title = title; }
    public final void setIdentificationNumber (int ID) { identificationNumber = ID; }
    public final void setPublicationDate (int publicationDate) { this.publicationDate = publicationDate;}
    public void setAvailable (boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }


    @Override
    public void takePublication() throws PublicationAvailabilityException{
        if(isAvailable) {
            todayDate = new Date();
            setAvailable(false);
        }
        else{
            throw new PublicationAvailabilityException(this, "Publication is not available", getAvailable());
        }
    }


    public String checkReturnDate() {
        return "Return until: " + getDueDate();
    }


    @Override
    public void returnPublication() {
        setDueDate(null);
        setAvailable(true);
    }



    @Override
    public Publication clone(){
        Publication clone = null;
        try{
            clone = (Publication) super.clone();
            clone.author = new String(this.author);
            clone.title = new String(this.title);
            clone.dueDate = (Date) this.dueDate.clone();
        } catch (CloneNotSupportedException exc) {
            exc.printStackTrace();
        }
        return clone;
    }


}

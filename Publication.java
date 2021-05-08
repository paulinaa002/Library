package library.publication;

import java.util.Date;

public abstract class Publication implements TakeableWithProlong {

    private String author;
    private String title;
    private int identificationNumber;
    private int publicationDate;
    private boolean isAvailable = true;
    public Date todayDate;
    private Date dueDate;


    public Publication(){
        this(new String(), new String());
    }

    public Publication(String author, String title){
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
    public final void setPublicationDate (int publicationDate) { this.publicationDate = publicationDate; }
    public void setAvailable (boolean isAvailable) { this.isAvailable = isAvailable; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public abstract String checkReturnDate();

}

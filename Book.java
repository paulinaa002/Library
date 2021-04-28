package library.publication;

import library.Publication;

import java.util.Calendar;
import java.util.Date;


public class Book extends Publication {
    private String genre;
    private Date returnUntil = new Date();

    public Book(){
        super();
    }

    public Book(String genre){
        super();
        this.genre = genre;
    }

    public Book(String author, String title, int identificationNumber, int publicationDate, boolean isAvailable, String genre){
        super(author, title, identificationNumber, publicationDate, isAvailable);
        this.genre = genre;
    }


    public void setGenre(String genre) { this.genre = genre; }
    public void setReturnUntil(Date returnUntil) { this.returnUntil = returnUntil; }

    public String getGenre() { return genre; }
    public Date getReturnUntil() { return returnUntil; }


    /*public void takeBook(){
        
           
        }
    }*/
    @Override
    public void takePublication(){
        Date date = new Date();
        Calendar returnUntil = Calendar.getInstance();
        returnUntil.setTime(date);
        returnUntil.add(Calendar.MONTH, +1);
        date = returnUntil.getTime();

    }

    public void returnBook(){
        //and returnDate should be =null
        setAvailable(true);
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\ngenre: " + genre +
                "\nis in library: " + getAvailable();
    }


}

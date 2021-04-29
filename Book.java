package library.publication;

import library.Publication;

import java.util.Calendar;
import java.util.Date;


public class Book extends Publication {
    private String genre;


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

    public String getGenre() { return genre; }


    @Override
    public void takePublication(){
        super.takePublication();
        Calendar dateNow = Calendar.getInstance();
        dateNow.setTime(todayDate);
        dateNow.add(Calendar.MONTH, +1);
        todayDate = dateNow.getTime();
        //System.out.println(todayDate);

    }

    public void returnBook(){
        todayDate = null;
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

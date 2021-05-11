package library.publication.book;

import library.LibraryException;
import library.publication.Publication;
import library.publication.PublicationIssueDateException;
import library.publication.PublicationNotAvailableException;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Book extends Publication {

    private String genre;
    private double fine;



    public Book(){

        super();
    }

    public Book(String genre) throws LibraryException{
        super();

        this.genre = genre;
    }

    public Book(String author, String title, int identificationNumber, int publicationDate, String genre) throws LibraryException {
        super(author, title, identificationNumber, publicationDate);

        year = Calendar.getInstance().get(Calendar.YEAR);
        if(publicationDate > year)
            throw new PublicationIssueDateException(this, "Publication is not released yet.", new Date());

        this.genre = genre;
    }


    public void setGenre(String genre) { this.genre = genre; }
    public void setFine(double fine) { this.fine = fine; }

    public String getGenre() { return genre; }
    public double getFine() { return fine; }


    @Override
    public void takePublication() throws PublicationNotAvailableException {
        if(getAvailable()) {
            super.takePublication();
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(todayDate);
            tempDate.add(Calendar.MONTH, +1);
            setDueDate(tempDate.getTime());
        }
        else{
            throw new PublicationNotAvailableException(this, "Book is not available");
        }
    }


@Override
    public void extendDueDate(){
        Calendar tempDate = Calendar.getInstance();
        tempDate.setTime(getDueDate());
        tempDate.add(Calendar.MONTH, +1);
        setDueDate(tempDate.getTime());
    }

    public long getDateDifferenceInDays() {
        Date currentDate = new Date();
        long days = Duration.between(getDueDate().toInstant(), currentDate.toInstant()).toDays();
        return days;
    }

    public void calculateFine(){
        if(getDateDifferenceInDays() > 0)
            fine = getDateDifferenceInDays() * 0.4;
        else
            fine = 0;
    }

    public String checkFine(){
        calculateFine();
        return "Your fine is " + fine;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) +
                "\nauthor: " + getAuthor() +
                "\ntitle: " + getTitle() +
                "\nID: " + getIdentificationNumber() +
                "\nyear: " + getPublicationDate() +
                "\ngenre: " + genre;
    }
}


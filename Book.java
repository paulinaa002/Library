package library.publication.book;

import library.publication.Publication;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Book extends Publication {

    private String genre;
    private double fine;


    public Book(){
        super();
    }

    public Book(String genre){
        super();
        this.genre = genre;
    }

    public Book(String author, String title, int identificationNumber, int publicationDate, String genre){
        super(author, title, identificationNumber, publicationDate);
        this.genre = genre;
    }


    public void setGenre(String genre) { this.genre = genre; }
    public void setFine(double fine) { this.fine = fine; }

    public String getGenre() { return genre; }
    public double getFine() { return fine; }


    public void takePublication(){
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
    public String checkReturnDate(){
        return "Return until: " + getDueDate();
    }

@Override
    public void returnPublication(){
        setDueDate(null);
        setAvailable(true);
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


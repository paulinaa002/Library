package library.publication.book;

import library.publication.*;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Book extends Publication {

    private String genre;
    private double fine;



    public Book(){
        super();
    }

    public Book(String genre) {
        super();

        this.genre = genre;
    }

    public Book(String author, String title, int identificationNumber, int publicationDate, String genre) {
        super(author, title, identificationNumber, publicationDate);
        this.genre = genre;
    }


    public void setGenre(String genre) { this.genre = genre; }
    public void setFine(double fine) { this.fine = fine; }

    public String getGenre() { return genre; }
    public double getFine() { return fine; }


    @Override
    public void takePublication() throws PublicationAvailabilityException {
        if(getAvailable()) {
            super.takePublication();
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(todayDate);
            tempDate.add(Calendar.MONTH, +1);
            setDueDate(tempDate.getTime());
        }
        else{
            throw new PublicationAvailabilityException(this, "Book is not available", getAvailable());
        }
    }


@Override
    public void extendDueDate(int amount) throws PublicationException{
        if(getAvailable()){
            throw new PublicationAvailabilityException(this, "Book is not taken", getAvailable());
        } else if (amount > 12){
            throw new PublicationException(this, "Extension time too long");
        }
        else {
            Calendar tempDate = Calendar.getInstance();
            tempDate.setTime(getDueDate());
            tempDate.add(Calendar.MONTH, +amount);
            setDueDate(tempDate.getTime());
        }
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


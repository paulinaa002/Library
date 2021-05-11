package library.publication;

import library.LibraryException;

import java.util.Date;

public class PublicationIssueDateException extends LibraryException {

    private Publication publication;
    private Date date;

    public PublicationIssueDateException() {

        super();
    }

    public PublicationIssueDateException (Publication publication, String message, Date date){
        super(message);
        this.date = date;
        this.publication = publication;
    }

    public Date getDate(){ return date;}
    public Publication getPublication() { return publication; }
}

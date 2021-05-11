package library.publication;

import library.LibraryException;

public class PublicationNotAvailableException extends LibraryException {

    private Publication publication;

    public PublicationNotAvailableException (){

        super();
    }

    public PublicationNotAvailableException (Publication publication, String message) {
        super(message);
        this.publication = publication;

    }

    public Publication getPublication() { return publication; }

}

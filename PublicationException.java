package library.publication;

public class PublicationException extends Exception {

    protected Publication publication;


    public PublicationException() {
        super();
    }

    public PublicationException(Publication publication, String message) {
        super(message);
        this.publication = publication;
    }

    public Publication getPublication() {
        return this.publication;
    }
}

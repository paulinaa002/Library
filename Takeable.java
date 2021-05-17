package library.publication;

public interface Takeable {

    void takePublication() throws PublicationAvailabilityException;
    void returnPublication();

}

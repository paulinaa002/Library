package library.publication;


public interface TakeableWithProlong extends Takeable {

    void extendDueDate(int amount) throws PublicationException;
}

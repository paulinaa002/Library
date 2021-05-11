package library;

import library.publication.Publication;
import library.publication.book.Book;

public class LibraryException extends Exception {


    public LibraryException() {

        super();
    }


    public LibraryException( String message) {
        super(message);
    }


}

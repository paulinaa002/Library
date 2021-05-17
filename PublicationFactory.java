package library.publication;

import library.publication.book.Book;
import library.publication.magazine.Magazine;

public class PublicationFactory {

    private PublicationFactory(){}

    public static Publication getPublication(String publicationType) {
        if(publicationType == null){
            return null;
        }
        if(publicationType.equalsIgnoreCase("book")){
            return new Book();
        } else if(publicationType.equalsIgnoreCase("magazine")){
            return new Magazine();
        }
        return null;
    }
}

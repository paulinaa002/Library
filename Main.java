package library;

import library.publication.Publication;
import library.publication.PublicationIssueDateException;
import library.publication.PublicationNotAvailableException;
import library.publication.book.Book;
import library.publication.magazine.Magazine;

public class Main {



    public static void main(String[] args) throws CloneNotSupportedException {

        try {
            Book book = new Book("", "Hamlet", 11122, 2001, "drama");

        } catch (PublicationIssueDateException exc) {
            exc.printStackTrace();
            System.out.println("Wrong creation date. It is in the future");
        } catch (LibraryException exc) {
            exc.printStackTrace();
        }


        try {
            Book book1 = new Book("Shakespeare", "Hamlet", 11122, 2025, "drama");

        } catch (PublicationIssueDateException exc) {
            exc.printStackTrace();
            System.out.println("Wrong creation date. It is after current date (" + exc.getDate() + ")");
        } catch (LibraryException exc) {
            exc.printStackTrace();
        }


        try {
            Book book2 = new Book("Shakespeare", "Hamlet", 11122, 2021, "drama");
            book2.setAvailable(false);
            book2.takePublication();

        }catch (PublicationNotAvailableException exc) {
            exc.printStackTrace();
            System.out.println("Trying to take a book that isn't available.");
        }catch (PublicationIssueDateException exc) {
            exc.printStackTrace();
            System.out.println("Wrong creation date. It is after current date (" + exc.getDate() + ")");
        } catch (LibraryException exc){
            exc.printStackTrace();
        }


        Magazine m1 = null;
        try{
            m1 = new Magazine("author", "title", 1122, 2001, 12);
        } catch (LibraryException exc){
            exc.printStackTrace();
        }
        if (m1 != null) {
            Magazine m2 = (Magazine) m1.clone();
            System.out.println(m1==m2); //ats: false, nes sukuriami 2 objektai su skirtingom nuorodom
            System.out.println(m1.getAuthor());
            System.out.println(m2.getAuthor());
            System.out.println(m1.getReleaseNo());
            System.out.println(m2.getReleaseNo());
        }

    }

}

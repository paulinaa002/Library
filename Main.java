package library;

import library.publication.Publication;
import library.publication.PublicationAvailabilityException;
import library.publication.PublicationException;
import library.publication.PublicationFactory;
import library.publication.book.Book;
import library.publication.magazine.Magazine;

import java.util.Date;

public class Main {



    public static void main(String[] args) throws PublicationAvailabilityException {


        Book book1 = new Book("Shakespeare", "Hamlet", 11122, 2002, "drama");
        Magazine magazine1 = new Magazine("author", "title", 212121, 2020, 13);

        book1.setAvailable(false);
        try{
            book1.takePublication();
        } catch (PublicationAvailabilityException exc){
            exc.printStackTrace();
            System.out.println("Book is not available");
        }

        try{
            magazine1.extendDueDate(16);
        } catch (PublicationAvailabilityException exc){
            exc.printStackTrace();
            System.out.println("Magazine is not taken");
        } catch (PublicationException exc){
            exc.printStackTrace();
        }

//*****************************************************************************
        Magazine original = new Magazine("author1", "title1", 221122, 2020, 13);
        original.takePublication();
        //original.setDueDate(new Date());
        Magazine copy = original.clone();
        System.out.println(original.toString());
        System.out.println();
        System.out.println(copy.toString());
        System.out.println();
        System.out.println(original == copy);
        System.out.println();
        System.out.println(original.getDueDate());
        System.out.println(copy.getDueDate());
        System.out.println();
        System.out.println("original.getAuthor() == copy.getAuthor() " + (original.getAuthor() == copy.getAuthor()));
        System.out.println("original.getAuthor() equals copy.getAuthor() " + (original.getAuthor().equals(copy.getAuthor())));
        System.out.println();
        System.out.println("original.getTitle() == copy.getTitle() " + (original.getTitle() == copy.getTitle()));
        System.out.println("original.getTitle() equals copy.getTitle() " + (original.getTitle().equals(copy.getTitle())));
        System.out.println();
        System.out.println("original.getIdentificationNumber() == copy.getIdentificationNumber() " + (original.getIdentificationNumber() == copy.getIdentificationNumber()));
        System.out.println();
        System.out.println("original.getDueDate() == copy.getDueDate() " + (original.getDueDate() == copy.getDueDate()));
        System.out.println(original.getDueDate());
        System.out.println(copy.getDueDate());



        System.out.println();
        Publication test1 = PublicationFactory.getPublication("Book");
        System.out.println(test1.toString());
        Publication test2 = PublicationFactory.getPublication("MAGAZINE");
        System.out.println(test2.toString());










        /*
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
*/
    }

}

package ariel.az.sugar;

import com.orm.SugarRecord;

public class Book extends SugarRecord<Book> {
    //propiedades
    String title;
    String edition;
    //constructor
    public Book(){
    }
    //sobrecarga del constructor
    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
    //encapsulamiento de los campos
    public String getTitle(){
        return title;
    }
    public void setTitle(String tilte){
        this.title = tilte;
    }
    public String getEdition(){
        return edition;
    }
    public void setEdition(String edition){
        this.edition = edition;
    }
}
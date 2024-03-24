//використовуючи hibernate:
//- створити табличку Word (id, value)
//- наповнити її
//- дістати всі value слів та запакувати в List .
//
//
//Створити клас Car з полями:
//id
//model,
//Type (ENUM)
//power,
//price,
//year.

import db.DBController;
import entities.Word;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = DBController.linkConnection();
        Transaction transaction = session.beginTransaction();

        Word lorem = new Word("lorem");
        Word ipsum = new Word("ipsum");
        Word dolor = new Word("dolor");
        Word sit = new Word("sit");

        session.persist(lorem);
        session.persist(ipsum);
        session.persist(dolor);
        session.persist(sit);

        transaction.commit();

        List<Word> allWords = session.createNativeQuery("SELECT * FROM Word", Word.class).list();

        System.out.println(allWords);


        session.close();
    }
}
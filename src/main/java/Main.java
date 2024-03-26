import db.ConnectionManager;

import entities.*;
import enums.ECarType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = ConnectionManager.connect();
        Transaction transaction = session.beginTransaction();

        Car audi = new Car()
                .setModel("A6")
                .setType(ECarType.HYBDRID)
                .setPrice(120_000)
                .setSpeed((short) 330)
                .setYear((short) 2019);

        session.persist(audi);

        License license = new License().setSeries("43GHA8FZ");

        session.persist(license);

        Tag tag1 = new Tag().setTitle("spring");

        session.persist(tag1);

        Owner andrew = new Owner().setName("Andrew").setLicense(license).setCars(List.of(audi)).setTags(List.of(tag1));

        session.persist(andrew);



        transaction.commit();
        session.close();
    }
}
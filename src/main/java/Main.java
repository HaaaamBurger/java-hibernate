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

        Owner andrew = new Owner().setName("Andrew").setLicense(license).setCars(List.of(audi));

        session.persist(andrew);

        transaction.commit();
        session.close();
    }
}
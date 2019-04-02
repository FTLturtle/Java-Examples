package jpa.crud;

import jpa.crud.entities.CD;
import jpa.crud.entities.Musician;
import jpa.crud.services.CDService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class RelationRunner {

    public static void main(String... args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("publishing");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDService service = new CDService(em);

        Set<Musician> tcq = new HashSet<>();
        tcq.add(new Musician(" Q-", "Tip"));
        tcq.add(new Musician("Phife", "Dawg"));
        tcq.add(new Musician("Shaheed", "Muhammad"));
        tcq.add(new Musician("Jarobi", "White"));


        CD cd = service.createCD(new CD("The Low End Theory", "Released: September 24, 1991", 12.5F, 90F, "Hip Hop", tcq));

        System.out.println("CD Persistend : " + cd);

        cd = service.findCD(cd.getId());

        System.out.println("Found CD : " + cd);

        System.out.println("    Musicians : " + cd.getMusicians());

        service.removeCD(cd);

        System.out.println("Removed CD : " + cd);
    }
}

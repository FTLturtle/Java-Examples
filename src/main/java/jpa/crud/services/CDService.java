package jpa.crud.services;

import jpa.crud.entities.CD;
import jpa.crud.entities.Musician;

import javax.persistence.*;
import java.util.Set;

public class CDService {

    EntityManager em = null;
    EntityTransaction tx = null;

    public CDService(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public CD createCD(String title, String description, Float unitCost, Float totalDuration, String genre, Set<Musician> musicians) {

        CD cd = new CD();
        cd.setTitle(title);
        cd.setDescription(description);
        cd.setUnitCost(unitCost);
        cd.setTotalDuration(totalDuration);
        cd.setGenre(genre);
        cd.setMusicians(musicians);

        tx.begin();
        em.persist(cd);
        tx.commit();

        return cd;
    }

    public CD createCD(CD cd) {
        tx.begin();
        em.persist(cd);
        tx.commit();
        return cd;
    }

    public CD findCD(Long id) {
        return em.find(CD.class, id);
    }

    public void removeCD(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
    }

    public void removeCD(CD cd) {
        CD cdToBeDeleted = em.merge(cd);
        tx.begin();
        em.remove(cdToBeDeleted);
        tx.commit();
        /*
        em.remove(em.merge(cd));
        /**/
    }

    public CD raiseUnitCost(Long id, Float raise) {
        CD cd = em.find(CD.class, id);
        if (cd != null) {
            tx.begin();
            cd.setUnitCost(cd.getUnitCost() + raise);
            tx.commit();
        }
        return cd;
    }

    public CD raiseUnitCost(CD cd, Float raise) {
        CD cdToBeUpdated = em.merge(cd);

        tx.begin();
        cdToBeUpdated.setUnitCost(cdToBeUpdated.getUnitCost() + raise);
        tx.commit();
        return cd;
    }
}

package app.daos;

import app.entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ArtistDAO {
    private static ArtistDAO instance;
    private static EntityManagerFactory emf;

    private ArtistDAO(EntityManagerFactory _emf) {
        emf = _emf;
    }

    public static ArtistDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new ArtistDAO(_emf);
        }
        return instance;
    }

    // Hent alle artister
    public List<Artist> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Artist> query = em.createQuery("SELECT a FROM Artist a", Artist.class);
            return query.getResultList();
        }
    }

    // Opret en artist
    public Artist create(Artist artist) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(artist);
            em.getTransaction().commit();
            return artist;
        }
    }

    // Opdater øl-priser eller spilletider (Update)
    public Artist update(Artist artist) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Artist updated = em.merge(artist);
            em.getTransaction().commit();
            return updated;
        }
    }

    // Slet artist (hvis de aflyser)
    public void delete(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Artist artist = em.find(Artist.class, id);
            if (artist != null) {
                em.remove(artist);
            }
            em.getTransaction().commit();
        }
    }

    public Artist getById(int artistId) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Artist.class, artistId);
        }
    }
}
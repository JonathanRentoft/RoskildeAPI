package app.utils;

import app.daos.ArtistDAO;
import app.entities.Artist;
import app.entities.User;
import jakarta.persistence.EntityManagerFactory;

public class Populator {
    public static void populate(EntityManagerFactory emf) {
        ArtistDAO dao = ArtistDAO.getInstance(emf);

        // Tjek om der er data, så vi ikke duplikerer ved genstart
        if (!dao.getAll().isEmpty()) return;

        System.out.println("---- POPULATING DATABASE WITH ARTISTS AND USERS ----");

        // -----------------------------------------------------------------------------------
        // 1. OPRET ARTISTER
        // -----------------------------------------------------------------------------------

        // --- ONSDAG ---
        dao.create(new Artist("Kendrick Lamar", "Orange Scene", "Onsdag", "22:00", "Hip Hop", "Kongen af moderne rap vender tilbage."));
        dao.create(new Artist("Heilung", "Arena", "Onsdag", "20:00", "Experimental", "Vikinge-ritualer, trommer og urkraft."));
        dao.create(new Artist("Jungle", "Orange Scene", "Onsdag", "18:00", "Funk/Soul", "Det ultimative dansefest i solnedgangen."));
        dao.create(new Artist("Khruangbin", "Arena", "Onsdag", "17:00", "Psychedelic", "Thai-funk inspireret chill-out session."));
        dao.create(new Artist("Lamin", "Orange Scene", "Onsdag", "15:00", "Hip Hop", "Danmarks nye rap-stjerne åbner Orange."));
        dao.create(new Artist("Brutalismus 3000", "Apollo", "Onsdag", "23:00", "Techno/Punk", "Hårdtslående Berlin-techno møder punk."));
        dao.create(new Artist("Zar Paulo", "Avalon", "Onsdag", "14:00", "Pop/Rock", "Dansk 80'er inspireret energiudladning."));
        dao.create(new Artist("Saint Clara", "Eos", "Onsdag", "16:00", "Pop/R&B", "Stor stemme og masser af attitude."));
        dao.create(new Artist("Noname", "Avalon", "Onsdag", "19:00", "Hip Hop/Poetry", "Intelligent og sjælfuld lyrik."));
        dao.create(new Artist("Action Bronson", "Arena", "Onsdag", "23:30", "Hip Hop", "Rap, mad og karisma fra Queens."));

        // --- TORSDAG ---
        dao.create(new Artist("21 Savage", "Orange Scene", "Torsdag", "22:00", "Hip Hop", "Trap-ikonet indtager hovedscenen."));
        dao.create(new Artist("PJ Harvey", "Arena", "Torsdag", "20:00", "Alternative", "Enestående rockikon med nyt materiale."));
        dao.create(new Artist("Skrillex", "Apollo", "Torsdag", "01:00", "Electronic", "Dubstep legenden vender op og ned på natten."));
        dao.create(new Artist("The Last Dinner Party", "Avalon", "Torsdag", "14:00", "Indie Pop", "Årets helt store britiske gennembrud."));
        dao.create(new Artist("Aurora", "Orange Scene", "Torsdag", "19:00", "Pop/Folk", "Magisk og eventyrlig pop fra Norge."));
        dao.create(new Artist("The Blaze", "Arena", "Torsdag", "00:00", "Electronic", "Emotionel elektronisk musik og vilde visuals."));
        dao.create(new Artist("Tinashe", "Apollo", "Torsdag", "21:00", "R&B/Pop", "Dansevenlige hits og stærk koreografi."));
        dao.create(new Artist("Blondshell", "Pavilion", "Torsdag", "13:00", "Indie Rock", "Rå og ærlig rock med 90'er vibes."));
        dao.create(new Artist("Omah Lay", "Avalon", "Torsdag", "18:00", "Afrobeats", "Afrikanske rytmer og lækker vokal."));
        dao.create(new Artist("Medina", "Orange Scene", "Torsdag", "16:00", "Pop", "Hele Danmarks popdronning sætter gang i festen."));

        // --- FREDAG ---
        dao.create(new Artist("Foo Fighters", "Orange Scene", "Fredag", "22:00", "Rock", "Dave Grohl og vennerne leverer rockshowet."));
        dao.create(new Artist("SZA", "Orange Scene", "Fredag", "00:30", "R&B", "En af verdens største stjerner lige nu."));
        dao.create(new Artist("Gilli", "Arena", "Fredag", "19:00", "Hip Hop", "Dansk raps absolutte sværvægter."));
        dao.create(new Artist("Charli XCX", "Apollo", "Fredag", "23:30", "Pop", "Hyperpop dronningen og rave-stemning."));
        dao.create(new Artist("Ice Spice", "Arena", "Fredag", "23:00", "Hip Hop", "Drill-prinsessen fra Bronx."));
        dao.create(new Artist("Barry Can't Swim", "Apollo", "Fredag", "02:00", "House", "Melodisk house man bliver glad af."));
        dao.create(new Artist("Alvvays", "Avalon", "Fredag", "17:00", "Indie Pop", "Drømmende guitarer og gode melodier."));
        dao.create(new Artist("Tyla", "Apollo", "Fredag", "20:00", "Amapiano", "Sydafrikanske vibes der har taget verden med storm."));
        dao.create(new Artist("Kim Gordon", "Pavilion", "Fredag", "21:00", "Noise Rock", "Sonic Youth legenden går solo."));
        dao.create(new Artist("Tom Odell", "Avalon", "Fredag", "15:00", "Singer/Songwriter", "Klaverballader der rammer hjertet."));

        // --- LØRDAG ---
        dao.create(new Artist("The Minds of 99", "Orange Scene", "Lørdag", "01:00", "Dansk Rock", "Nationalorkesteret lukker hele festivalen."));
        dao.create(new Artist("Doja Cat", "Orange Scene", "Lørdag", "21:00", "Pop/Rap", "Global superstjerne med vildt sceneshow."));
        dao.create(new Artist("Kali Uchis", "Arena", "Lørdag", "23:00", "R&B/Latin", "Sjælfuld og sensuel latin-pop."));
        dao.create(new Artist("J Hus", "Arena", "Lørdag", "20:00", "Hip Hop/Afroswing", "Britiske vibes af højeste kaliber."));
        dao.create(new Artist("Romy", "Apollo", "Lørdag", "23:00", "Electronic/Pop", "The xx-sangerinden med klub-bangers."));
        dao.create(new Artist("Young Fathers", "Avalon", "Lørdag", "22:00", "Experimental", "Intenst, politisk og genrebrydende."));
        dao.create(new Artist("Nia Archives", "Apollo", "Lørdag", "02:00", "Jungle/DnB", "Fremtiden inden for Jungle musik."));
        dao.create(new Artist("PJ Morton", "Avalon", "Lørdag", "16:00", "Soul/R&B", "Maroon 5 keyboardspilleren med sit eget soul-show."));
        dao.create(new Artist("Kesi", "Orange Scene", "Lørdag", "17:00", "Hip Hop", "Hitparade fra Nørrebro."));
        dao.create(new Artist("Ukendt Kunstner", "Arena", "Lørdag", "01:00", "Hip Hop", "De genforenede legender lukker Arena."));


        // -----------------------------------------------------------------------------------
        // 2. OPRET BRUGERE
        // -----------------------------------------------------------------------------------
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            // Opretter admin og user hvis de ikke findes (simpelt tjek for at undgå fejl)
            // Bemærk: I et rigtigt setup bør UserDAO håndtere "findes brugeren allerede?"
            User admin = new User("admin", "1234", "admin");
            User user = new User("user", "1234", "user");

            // Brug merge i stedet for persist for en sikkerheds skyld, hvis du kører clean up
            em.merge(admin);
            em.merge(user);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Fejl ved oprettelse af brugere: " + e.getMessage());
        }

        System.out.println("---- DONE POPULATING ----");
    }
}
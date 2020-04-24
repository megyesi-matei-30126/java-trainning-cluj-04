import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Premiu oscar1990 = new Premiu("oscar", 1990);
        Premiu oscar1995 = new Premiu("oscar", 1995);
        Premiu oscar2000 = new Premiu("oscar", 2000);
        Premiu oscar2005 = new Premiu("oscar", 2005);
        Premiu oscar2010 = new Premiu("oscar", 2010);
        Premiu oscar2018 = new Premiu("oscar", 2018);

        Actor actorOscar2 = new Actor("actor cu 2 oscaruri", 40, new Premiu[]{oscar1990, oscar2000});
        Actor actorOscar2010 = new Actor("acotr cu oscar din 2010", 56, new Premiu[]{oscar2010});
        Actor actorOscar3 = new Actor("actor cu 3 oscaruri", 25, new Premiu[]{oscar1995, oscar2005, oscar2018});
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 28, new Premiu[]{oscar2018});
        Actor actorFaraPremii01 = new Actor("actor fara premii 01", 20, new Premiu[]{});
        Actor actorFaraPremii02 = new Actor("actor fara premii 02", 25, new Premiu[]{});

        Film film1 = new Film( 2018,"film cu actori de oscar", new Actor[]{actorOscar2, actorOscar2018});
        Film film2 = new Film( 2013,"film fara actori de oscar", new Actor[]{actorFaraPremii01, actorFaraPremii02});
        Film film3 = new Film(1996, "film cu actori de oscar", new Actor[]{actorFaraPremii01, actorOscar2010, actorOscar3});
        Film film4 = new Film(2002, "film cu actori de oscar", new Actor[]{actorOscar2010, actorFaraPremii02});
        Film film5 = new Film(2005, "film fara actori de oscar", new Actor[]{actorFaraPremii01});
        Film[] filme = new Film[]{film1, film2, film3, film4, film5};

        Studio studio1 = new Studio("MVP", new Film[]{film4, film5});
        Studio studio2 = new Studio("Disney", new Film[]{film1, film2, film3});
        Studio studio3 = new Studio("ABC", new Film[]{film1});
        Studio studio4 = new Studio("WWW", new Film[]{film4, film3});
        Studio studio5 = new Studio("WWW", new Film[]{film4, film3, film5});

        Studio[] studioDatabase = new Studio[]{studio1, studio2, studio3, studio4, studio5};

        Scanner scanner = new Scanner(System.in);
        byte numberOfMovies = 2;
        System.out.println("The studio names that have published more than " + numberOfMovies + " movies: ");

        byte i = 1;
        for (Studio studio : studioDatabase) {
            if (studio.getFilme().length > numberOfMovies) {
                System.out.println(i + ". " + studio.getNume());
                i++;
            }
        }

        System.out.println("Enter actor name: ");
        String actorNameSearch = scanner.nextLine();
        System.out.println("The studio names in which plays the actor with the name '" + actorNameSearch + "':");

        for (Studio studio : studioDatabase){
            for (Film film : studio.getFilme()){
                for (Actor actor : film.getActori()){
                    if (actor.getNume().equals(actorNameSearch)){
                        System.out.println(studio.getNume());
                    }
                }
            }
        }

        byte actorAge = 50;
        System.out.println("Movie names in wich playes actors with age above that " + actorAge + ":");

        for (Film film : filme){
            for (Actor actor : film.getActori()){
                if (actor.getVarsta() > actorAge){
                    System.out.println(film.getNume());
                }
            }
        }
    }
}

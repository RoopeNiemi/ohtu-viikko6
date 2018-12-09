package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        System.out.println("10G 10A PHI");
        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("\nno goals");
        m = new Not(new HasAtLeast(1, "goals"));

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\nCOMPARING");
        m = new HasFewerThan(1, "goals");

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\n40G or 60A or 85P");
        m = new Or(new HasAtLeast(40, "goals"),
                new HasAtLeast(60, "assists"),
                new HasAtLeast(85, "points")
        );

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\nQuerybuilder");
        QueryBuilder query = new QueryBuilder();

        m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "goals").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("\nOr");
        m = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "goals")
                        .hasFewerThan(20, "assists").build(),
                query.playsIn("EDM")
                        .hasAtLeast(60, "points").build()
        ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}

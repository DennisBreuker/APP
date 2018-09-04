package nl.han.asd.app.lesson2;

public class Hanoi {
    private static final int AANTAL_SCHIJVEN = 7;
    private static final int START = 0;
    private static final int VIA = 1;
    private static final int DOEL = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        verplaats(AANTAL_SCHIJVEN, START, VIA, DOEL);
    }

    /**
     * Verplaatst een hanoi-toren van een plek naar de andere.
     *
     * @param aantalSchijven Hoogte van de toren.
     * @param start Plek waar de toren zich bevindt.
     * @param tussenplek Extra plek om te gebruiken.
     * @param doel Plek waar de toren naartoe moet.
     */
    public static void verplaats(int aantalSchijven, int start, int tussenplek, int doel) {
        // stopconditie: 0 schijven over, dan zijn we klaar
        if (aantalSchijven <= 0) {
            return;
        }
        // los het recursief op
        // 1) de stapel op 1 na verplaatsen van start naar tussenplek
        verplaats(aantalSchijven-1, start, doel, tussenplek);
        // 2) de onderste schijf verplaatsen van start naar doel
        System.out.println("Verplaats schijf van plek " + (char)(start+'A')
                + " naar plek " + (char)(doel+'A'));
        // 3) de stapel op 1 na verplaatsen van tussenplek naar doel
        verplaats(aantalSchijven-1, tussenplek, start, doel);
    }
}

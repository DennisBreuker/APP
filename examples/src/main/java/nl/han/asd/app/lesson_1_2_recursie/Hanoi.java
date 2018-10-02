package nl.han.asd.app.lesson_1_2_recursie;

public class Hanoi {
    private static final int AANTAL_SCHIJVEN = 64;
    private static final int START = 1;
    private static final int VIA = 2;
    private static final int DOEL = 3;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        verplaats(AANTAL_SCHIJVEN, START, DOEL, VIA);
    }

    /**
     * Verplaatst een hanoi-toren van een plek naar de andere.
     *
     * @param aantalSchijven Hoogte van de toren.
     * @param start Plek waar de toren zich bevindt.
     * @param doel Plek waar de toren naartoe moet.
     * @param tussenplek Extra plek om te gebruiken.
     */
    public static void verplaats(int aantalSchijven, int start, int doel, int tussenplek) {
        // stopconditie: 1 schijf over, dat is gemakkelijk
        if (aantalSchijven == 1) {
            System.out.printf("Verplaats schijf van plek %d naar plek %d\n", start, doel);
        } else {
            // los het recursief op
            // 1) de stapel op 1 na verplaatsen van start naar tussenplek
            verplaats(aantalSchijven - 1, start, tussenplek, doel);
            // 2) de onderste schijf verplaatsen van start naar doel
            verplaats(1, start, doel, tussenplek);
            // 3) de stapel op 1 na verplaatsen van tussenplek naar doel
            verplaats(aantalSchijven - 1, tussenplek, doel, start);
        }
    }
}

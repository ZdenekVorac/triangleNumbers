import java.util.Iterator;

// Třída, která bude generovat trojúhelníková čísla
public class TriangleNumbers implements Iterable<Integer> {
    private int limit; // Maximální počet trojúhelníkových čísel

    // Konstruktor třídy, který nastaví limit
    public TriangleNumbers(int limit) {
        this.limit = limit;
    }

    // Metoda, která vrací iterátor pro trojúhelníková čísla
    @Override
    public Iterator<Integer> iterator() {
        return new TriangleIterator();
    }

    // Vnitřní třída, která implementuje iterátor
    private class TriangleIterator implements Iterator<Integer> {
        private int current = 1; // Aktuální index, sleduje počet vygenerovaných čísel
        private int n = 1; // Aktuální číslo, které se používá k výpočtu trojúhelníkového čísla

        // Metoda, která kontroluje, zda máme další číslo
        @Override
        public boolean hasNext() {
            return current <= limit; // Kontrola, zda jsme dosáhli limitu
        }

        // Metoda, která vrací další trojúhelníkové číslo
        @Override
        public Integer next() {
            int triangleNumber = n * (n + 1) / 2; // Výpočet trojúhelníkového čísla
            n++; // Zvýšení hodnoty n pro další iteraci
            current++; // Zvýšení aktuálního indexu
            return triangleNumber; // Vrácení trojúhelníkového čísla
        }
    }

    // Hlavní metoda, která spouští program
    public static void main(String[] args) {
        TriangleNumbers triangleNumbers = new TriangleNumbers(10); // Vytvoření instance s limitem 10
        for (int number : triangleNumbers) { // Iterace přes trojúhelníková čísla
            System.out.println(number); // Výpis trojúhelníkového čísla na konzoli
        }
    }
}

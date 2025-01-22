import java.util.ArrayList;
import java.util.Scanner;

public class Shuffles2 {
    public static void main(String[] args) {
        int count = 34;
        ArrayList<Integer> deck = new ArrayList<>();

        for (int k = 1; k <= count; k++) {
            deck.add(k);
        }
        System.out.println("Deck of " + count + " cards: " + shuffle(new ArrayList<>(deck), new ArrayList<>(deck), 0) + " shuffles");
        deck.clear();

    }
    public static int shuffle(ArrayList<Integer> initial, ArrayList<Integer> deck, int times) {
        Scanner in = new Scanner(System.in);

        times++;
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        boolean partOne = false;
        int breakpoint = 0;

        for (double i = 0; i < deck.size(); i++) {
            breakpoint = deck.size() / 2 + (((double) deck.size() / 2) % 1 == 0 ? 0 : 1);
//            System.out.println("Breakpoint: " + breakpoint);
            if (i >= breakpoint && !partOne) {
                partOne = true;
//                System.out.println("Switched partOne at value " + i + " compared to " + ((double) deck.size() / 2));
            }

            if (partOne) {
                second.add(deck.get((int) i));
            } else {
                if (i < deck.size()) {
                    first.add(deck.get((int) i));
                }
            }
        }

        ArrayList<Integer> shuffled = new ArrayList<>();
        for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
            if (i < first.size()) {
                shuffled.add(first.get(i));
            }
            if (i < second.size()) {
                shuffled.add(second.get(i));
            }
        }

        for (int i : shuffled) {
            System.out.println(i);
        }
        System.out.println("");

        if (shuffled.equals(initial)) {
            System.out.println("Finished!");
            System.out.println("");
            return times;
        } else {
            System.out.println("Press enter to go again");
            System.out.println("");
            String dummy = in.next();
            return shuffle(initial, shuffled, times);
        }
    }

}
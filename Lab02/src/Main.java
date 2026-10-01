//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Poker pokerGame = new Poker();
        Hand h1 = new Hand("5C 6C 7C 8C 9C");
        Hand h2 = new Hand("7S 7D 7H 7C 9D");
        Hand h3 = new Hand("2C 2H 7D JC 9S");

        pokerGame.addHand(h1);
        pokerGame.addHand(h2);
        pokerGame.addHand(h3);

        System.out.println(h1.kind());
        System.out.println(h2.kind());
        System.out.println(h3.kind());

        System.out.println(pokerGame.bestHand().kind());

    }
}
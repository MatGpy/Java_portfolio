import javax.swing.*;
import java.awt.*;

public class GameRulesWindow {
    private JFrame gameRulesFrame = new JFrame();
    GameRulesWindow() {
        gameRulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameRulesFrame.setSize(500,500);
        gameRulesFrame.add(new JLabel("<html><body style='width: 100%'>"+
        "<p>Gra w statki - w tej grze, celem użytkownika jest zestrzelenie wszystkich statków przeciwnika zanim wszystkie jego statki zostaną zestrzelone przez przeciwnika.</p>" +
        "<p>Przebieg gry:</p>" +
        "Na początek, użytkownik musi umieścić wszystkie swoje statki (jest ich 15) na swojej planszy - aby to zrobić, użytkownik musi wpisać"+
        " w przeznaczone do tego pola tekstowe (umieszczone powyżej planszy gracza i przeciwnika) współrzędne pola tablicy (numer rzędu i kolumny pola na planszy), do którego chce on wstawić swój statek "+
        " a po wyborze współrzędnych wcisnąć przycisk 'Umieść statek' - po wykonaniu tych kroków, wybrane pole zostanie zaznaczone symbolem '1'. Po umieszczeniu wszystkich swoich statków,"+
        " użytkownik może przejść do strzelania w statki na planszy przeciwnika - robi się to poprzez kliknięcie w odpowiedni przycisk na planszy przeciwnika"+
        " odzwierciedlający pole na planszy przeciwnika, natomiast po wybraniu przez użytkownika pola, wybrany przycisk nie będzie już dostępny do wciśnięcia."+
        " Po takim strzale, strzału dokonuje też przeciwnik - pole na planszy gracza, w które strzelił przeciwnik, zostanie zaznaczone symbolem 'X'."+
        "<p>Koniec gry:</p>" +
        "Gra się kończy wtedy, gdy użytkownik zestrzeli wszystkie statki przeciwnika zanim zrobi to przeciwnik (wtedy dochodzi do wygranej użytkownika), lub"+
        " wtedy, gdy przeciwnik zestrzeli wszystkie statki na planszy użytkownika (wtedy ogłoszona zostaje porażka użytkownika)." +
        "<p>Uwagi:</p>" +
        "Wartości wybranych przez użytkownika rzędów i kolumn pól, do których maja być wstawione statki (a więc wartości wstawiane do dwóch pól tekstowych na górze), "+
        "muszą być liczbami całkowitymi, nie mniejszymi niż 1 i nie większymi niż 9." +
        "</body></html>"));
        gameRulesFrame.setVisible(true);
    }

}
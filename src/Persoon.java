import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Persoon {
    private String naam;
    private Double budget;
    private ArrayList<Game> games=new ArrayList<>();

    public Persoon(String nm,Double bud){naam=nm;budget=bud;}

    public Double getBudget() {return budget;}

    public boolean koop(Game g) {
        boolean ant = false;
        boolean tna = false;
        for (Game z : games) {tna = g.equals(z);}
        if (g.huidigeWaarde() < budget && !tna) {
            budget = budget - g.huidigeWaarde();
            games.add(g);
            ant = true;
        }
        return ant;}
    public boolean verkoop(Game g,Persoon koper){
        boolean ant = false;
        boolean tna = false;
        boolean nat = false;
        for (Game z : koper.games) {tna = g.equals(z);}
        for (Game z : games) {nat = g.equals(z);}
        if (g.huidigeWaarde() < koper.budget && !tna && nat) {
            budget = budget + g.huidigeWaarde();
            games.remove(g);
            koper.games.add(g);
            koper.budget = koper.budget - g.huidigeWaarde();
            ant = true;
        }
        return ant;}

    public Game zoekGameOpNaam(String s){
        for (Game z : games) {
            if (Objects.equals(z.getNaam(), s)) {
                return z;
            }
        }
    return null;}

    public ArrayList bepaalGamesNietInBezit(ArrayList<Game> teKoop){
        int del = 0;
        for (Game z : games){
            while (del < games.size()){
                if (z==games.get(del)) {
                    teKoop.remove(z);
                }
                del = del + 1;}
        }
        return teKoop;
    }

    public ArrayList bepaalGamesNietInBezitmetrj(ArrayList<Game> teKoop){
        int del = 0;
        for (Game z : games){
            while (del < games.size()){
                if (z.getNaam().equals(games.get(del).getNaam()) &&z.getReleaseJaar()==games.get(del).getReleaseJaar()) {
                    teKoop.remove(z);
                }
                del = del + 1;}
        }
        return teKoop;
    }

    public String toString(){
        String comma = "%.2f";
        StringBuilder x = new StringBuilder(naam + " heeft een budget van €" + (String.format(Locale.FRANCE, comma, budget)) + " en bezit de volgende games:");
    if (games == null){return x.toString();}
    else {
        int del = 0;
        while (del < games.size() ){
            x.append("\n").append(games.get(del));
        del = del + 1;}
        return x.toString();}}
}

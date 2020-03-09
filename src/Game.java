import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Game {
    private String naam;
    private int releaseJaar;
    private Double nieuwprijs;

    public Game(String nm, int rj, Double nwpr){naam=nm;releaseJaar=rj;nieuwprijs=nwpr;}

    public String getNaam(){return naam;}

    public int getReleaseJaar(){return releaseJaar;}

    public double huidigeWaarde() {
        int vandaag = LocalDate.now().getYear();
        int verlager = vandaag;

        if (releaseJaar==vandaag){return nieuwprijs;}
        if (releaseJaar+1==vandaag){
            double nieuweWaarde = 0;
            while (verlager > releaseJaar) {
                nieuweWaarde = nieuwprijs - ((nieuwprijs / 10) * 3);
                verlager= verlager-1; }
            return (nieuweWaarde);
        }
        else {
        double nieuweWaarde = 0;
        while (verlager > releaseJaar) {
            nieuwprijs=nieuwprijs - ((nieuwprijs / 10) * 3);
            verlager= verlager-1; }
        return nieuwprijs;
        }
    }
    public boolean equals(Object andereObject) {
        boolean gelijkeObjecten = false;
        if (andereObject instanceof Game){
            Game andereGame = (Game) andereObject;
            if (this.naam.equals(andereGame.naam)&&
                    this.releaseJaar==andereGame.releaseJaar){
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString(){
        String comma = "%.2f";
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €"+ String.format(Locale.FRANCE, comma, nieuwprijs) +" nu voor: €" + String.format(Locale.FRANCE, comma,huidigeWaarde());}
}

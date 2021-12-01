import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.model.Fahrzeug;

public class MainProgram {

    private static List<Fahrzeug> fahrzeugList = new List<Fahrzeug>();

    /**
     * Die Main-Methode von Java startet das Programm. Sie ist einzigartig im ganzen Projekt.
     * Sie startet das Framework. Weitere Details zum Ablauf kann man sehen, wenn man mit STRG+Linksklick auf
     * "startFramework()" in der Methode klickt.
     *
     * Der gesamte Prozess endet mit dem Erzeugen eines Objekts der Klasse "ProgramController", die sich im Paket "my_project > control"
     * befindet. Dort sollte deine Arbeit beginnen.
     */
    public static void main(String[] args){
        //MainController.startFramework();
        appendFahrzeuge(500);
        fahrzeugList.toFirst();
        int count = 0;
        while(fahrzeugList.hasAccess()){
            System.out.println(count + " - Typ: " + fahrzeugList.getContent().getTypNummer() + " Räder: " + fahrzeugList.getContent().getAnzahlRaeder());
            count++;
            fahrzeugList.next();
        }
        System.out.println("Alle Fahrzeuge mit Typnummer 200: " + checkTypNummer(200));
        System.out.println("PS aller Fahrzeuge zusammen: " + getAllPS());
        printDreiraeder();
        System.out.println("Erstes Fahrzeug mit den wenigsten PS - Typ: " + wenigstePS().getTypNummer() + ", PS: " + wenigstePS().getPS() + ", Räder: " + wenigstePS().getAnzahlRaeder());
        printAllWenigstePS();
        removeFahrzeugeOfType(69);
    }

    public static void appendFahrzeuge(int amount) {
        for (int count = 0; count < amount; count++){
            Fahrzeug newFahrzeug = new Fahrzeug((int) (Math.random() * 999 + 1), (int) (Math.random() * 170 + 30), (int) (Math.random() * 3 + 2));
            fahrzeugList.append(newFahrzeug);
        }
    }

    public static int checkTypNummer(int nummer){
        fahrzeugList.toFirst();
        int count = 0;
        while(fahrzeugList.hasAccess()){
            if(fahrzeugList.getContent().getTypNummer() == nummer){
                count++;
            }
            fahrzeugList.next();
        }
        return count;
    }

    public static int getAllPS(){
        int count = 0;
        fahrzeugList.toFirst();
        while(fahrzeugList.hasAccess()){
            count += fahrzeugList.getContent().getPS();
            fahrzeugList.next();
        }
        return count;
    }

    public static void printDreiraeder(){
        System.out.print("Typen der Dreiräder: ");
        fahrzeugList.toFirst();
        while(fahrzeugList.hasAccess()) {
            if(fahrzeugList.getContent().getAnzahlRaeder() == 3) {
                System.out.print(" " + fahrzeugList.getContent().getTypNummer() + ",");
            }
            fahrzeugList.next();
        }
        System.out.println();
    }

    public static Fahrzeug wenigstePS(){
        Fahrzeug f = null;
        fahrzeugList.toFirst();
        int count = fahrzeugList.getContent().getPS();
        while(fahrzeugList.hasAccess()){
            if(fahrzeugList.getContent().getPS() < count){
                count = fahrzeugList.getContent().getPS();
                f = fahrzeugList.getContent();
            }
            fahrzeugList.next();
        }
        return f;
    }

    public static void printAllWenigstePS(){
        System.out.println("Alle Fahrzeuge mit den wenigsten PS: ");
        int i = 0;
        fahrzeugList.toFirst();
        int count = fahrzeugList.getContent().getPS();
        while(fahrzeugList.hasAccess()){
            if(fahrzeugList.getContent().getPS() <= count){
                count = fahrzeugList.getContent().getPS();
            }
            fahrzeugList.next();
        }
        fahrzeugList.toFirst();
        while(fahrzeugList.hasAccess()) {
            if(fahrzeugList.getContent().getPS() == count) {
                System.out.println(i + " - Typ: " + fahrzeugList.getContent().getTypNummer() + ", PS: " + fahrzeugList.getContent().getPS() + ", Räder: " + fahrzeugList.getContent().getAnzahlRaeder());
                i++;
            }
            fahrzeugList.next();
        }
    }

    public static void removeFahrzeugeOfType(int type) {
        fahrzeugList.toFirst();
        while(fahrzeugList.hasAccess()){
            if(fahrzeugList.getContent().getTypNummer() == type) fahrzeugList.remove();
        }
        fahrzeugList.next();
    }
}

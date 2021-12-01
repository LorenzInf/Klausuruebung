package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Fahrzeug {

    private int typNummer; // 1-999
    private int ps; // 30 - 200
    private int anzahlRaeder; // 2 - 4

    public Fahrzeug(int typNummer, int ps, int anzahlRaeder){
        this.typNummer = typNummer;
        this.ps = ps;
        this.anzahlRaeder = anzahlRaeder;
    }

    public int getTypNummer() {
        return typNummer;
    }

    public int getPS() {
        return ps;
    }

    public int getAnzahlRaeder() {
        return anzahlRaeder;
    }

    public void setTypNummer(int typNummer) {
        this.typNummer = typNummer;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setAnzahlRaeder(int anzahlRaeder) {
        this.anzahlRaeder = anzahlRaeder;
    }
}

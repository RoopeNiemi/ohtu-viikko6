/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komennot;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author User
 */
public abstract class Laskuoperaatio implements Komento {

    protected TextField syoteKentta;
    protected TextField tulosKentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;
    protected Sovelluslogiikka edellinenTilanne;

    public Laskuoperaatio(TextField syoteKentta, TextField tulosKentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syoteKentta = syoteKentta;
        this.tulosKentta = tulosKentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.edellinenTilanne = new Sovelluslogiikka();
    }

    @Override
    public void suorita() {

    }
    
    @Override
    public void peru() {
    }
}

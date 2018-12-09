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
public class Nollaa extends Laskuoperaatio {

    public Nollaa(TextField syoteKentta, TextField tulosKentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(syoteKentta, tulosKentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        tulosKentta.setText(String.valueOf(sovellus.tulos()));
        syoteKentta.setText("");
        if (sovellus.tulos() == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

}

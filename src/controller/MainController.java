package controller;

import model.Luhn;
import view.MainView;

import java.awt.event.ActionEvent;

public class MainController {
    private final MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        mainView.setGeneriereButtonListener( this::performGeneriere );
        mainView.setPrüfeButtonListener( this::performPrüfe );
        mainView.setFindeButtonListener( this::performFinden );
    }

    private void performFinden(ActionEvent actionEvent) {
        String currentNumber = mainView.getNummer();
        while ( !Luhn.check(currentNumber + "0") ||
                !Luhn.check(currentNumber + "00") ) {
            long cn = Long.parseLong(currentNumber) + 1;
            currentNumber = String.valueOf(cn);
            mainView.setNummer( currentNumber );
        }
    }

    private void performPrüfe(ActionEvent actionEvent) {
        mainView.setValid(Luhn.check(mainView.getNummer()));
    }

    private void performGeneriere(ActionEvent actionEvent) {
        mainView.setValid(true);
        mainView.setNummer( Luhn.generate( mainView.getNummer() ) );
    }

    public static void main(String[] args) {
        new MainController(new MainView());
    }
}

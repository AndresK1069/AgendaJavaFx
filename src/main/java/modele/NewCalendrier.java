package modele;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;

import java.awt.event.ActionEvent;

public class NewCalendrier implements ConstantesCalendrier {

    public NewCalendrier() {
        Date today = new Date();
        ToggleGroup buttonGroup = new ToggleGroup();
        for (int numMois = 1; numMois<=12 ; numMois++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois,today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() / 7 + 1);
            tilePane.setId("opaque");
            for (String jourAB : JOURS_SEMAINE_ABR){
                Label labelJour = new Label(jourAB);
                tilePane.getChildren().add(labelJour);
            }
        for(DateCalendrier date : monthCalendar.getDates()){
            ToggleGroup boutonDate = new ToggleGroup(Integer.toString(date.getJour()));
            boutonDate.setToggleGroup(buttonGroup);
            tilePane.getChildren().add(boutonDate);
            boutonDate.setUserData(date);
            boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ............................
                }
            });
            if (date.getMois() != monthCalendar.getDates()){
                boutonDate.setId("dateHorsMois");
            }
            if (date.isToday()){
                boutonDate.setId("today");
            }
        }
        tilePane.setAccessibleText(MOIS[numMois-1]);
        stackPaneMois.getChildren().add(tilePane);
    }


    }
}

package modele;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;




public class NewCalendrier  extends VBox implements ConstantesCalendrier {

    public NewCalendrier() {
        Date today = new Date();
        Label labelMois = new Label(MOIS[0]);
        StackPane stackPaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();

        for (int numMois = 1; numMois<=12 ; numMois++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois,today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() / 7 + 1);
            tilePane.setId("opaque");
            for (String jourAB : JOURS_SEMAINE){
                Label labelJour = new Label(jourAB);
                tilePane.getChildren().add(labelJour);
            }
        for(DateCalendrier date : monthCalendar.getDates()){
            ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
            boutonDate.setToggleGroup(buttonGroup);
            tilePane.getChildren().add(boutonDate);
            boutonDate.setUserData(date);
            boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    moving(stackPaneMois, MOIS[today.getMois()]);
                }
            });
            if (date.getMois() != monthCalendar.getMois() ){
                boutonDate.setId("dateHorsMois");
            }
            if (date.isToday()){
                boutonDate.setId("today");
            }
        }
        tilePane.setAccessibleText(MOIS[numMois-1]);
        stackPaneMois.getChildren().add(tilePane);
    }
        getChildren().add(stackPaneMois);

        HBox VButton = new HBox();
        this.getChildren().add(VButton);
        this.getChildren().add(labelMois);

        ToggleButton boutonDoubleBefore = new ToggleButton();
        boutonDoubleBefore.setText("<<");
        VButton.getChildren().add(boutonDoubleBefore);

        ToggleButton boutonBefore = new ToggleButton();
        boutonBefore.setText("<");
        VButton.getChildren().add(boutonBefore);

        ToggleButton boutonNext = new ToggleButton();
        boutonNext.setText(">");
        VButton.getChildren().add(boutonNext);

        ToggleButton boutonDoubleNext = new ToggleButton();
        boutonDoubleNext.setText(">>");
        VButton.getChildren().add(boutonDoubleNext);

        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stackPaneMois.getChildren().get(0).toFront();
                labelMois.setText(stackPaneMois.getChildren().get(11).getAccessibleText());
            }

        });

        boutonBefore.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stackPaneMois.getChildren().get(11).toBack();
                labelMois.setText(stackPaneMois.getChildren().get(11).getAccessibleText());
            }
        });

        boutonDoubleNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                moving(stackPaneMois, MOIS[11]);
                labelMois.setText(stackPaneMois.getChildren().get(11).getAccessibleText());
            }
        });

        boutonDoubleBefore.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                before(stackPaneMois, MOIS[0]);
                labelMois.setText(stackPaneMois.getChildren().get(11).getAccessibleText());
            }

    });
        setFillWidth(false);
    }

    public void moving(StackPane tmp,String mois){
            while (tmp.getChildren().get(0).getAccessibleText().compareTo(mois) != 0) {
                tmp.getChildren().get(0).toFront();
            }
        }

    public void before(StackPane tmp, String mois){
        while (tmp.getChildren().get(11).getAccessibleText().compareTo(mois) != 0) {
            tmp.getChildren().get(11).toBack();
        }
    }



}
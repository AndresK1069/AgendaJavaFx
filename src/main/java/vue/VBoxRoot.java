package vue;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;

import modele.DateCalendrier;



public class VBoxRoot extends VBox  implements ConstantesCalendrier {

    public VBoxRoot() {
        DateCalendrier aujourdhui = new DateCalendrier();
        /*Label labelANN = new Label(MOIS[aujourdhui.getMois() - 1] + " " + aujourdhui.getAnnee());
        VBoxRoot.setMargin(labelANN, new Insets(14));
        labelANN.setId("today");

        this.getChildren().addAll(labelANN);*/

        StackPane stackPaneMois = new StackPane();

        HBox VButton = new HBox();
        this.getChildren().add(VButton);




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






        for (int i = 1; i <= 12; i++) {
            CalendrierDuMois var112 = new CalendrierDuMois(i, aujourdhui.getAnnee());
            ScrollPane scrollPaneMois = new ScrollPane();
            VBox vbox2 = new VBox();

            for (DateCalendrier Forvar : var112.getDates()) {
                Label tmp = new Label(Forvar.toString());
                vbox2.getChildren().add(tmp);

            }
            scrollPaneMois.setContent(vbox2);
            scrollPaneMois.setAccessibleText(MOIS[i-1]);

            stackPaneMois.getChildren().add(scrollPaneMois);


        }

        this.getChildren().addAll(stackPaneMois);

        moving(stackPaneMois, MOIS[aujourdhui.getMois()]);

        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stackPaneMois.getChildren().get(0).toFront();
            }
        });

        boutonBefore.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stackPaneMois.getChildren().get(11).toBack();
            }
        });

        boutonDoubleNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                moving(stackPaneMois, MOIS[11]);
            }
        });

        boutonDoubleBefore.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                before(stackPaneMois, MOIS[0]);

            }
        });

    }

    public void moving(StackPane tmp,String mois){
        while (tmp.getChildren().get(0).getAccessibleText().compareTo(mois) != 0) {
            tmp.getChildren().get(0).toFront();
        }
        tmp.getChildren().get(0).toFront();

    }
    public void before(StackPane tmp, String mois){
        while (tmp.getChildren().get(11).getAccessibleText().compareTo(mois) != 0) {
            tmp.getChildren().get(11).toBack();
        }
    }

}

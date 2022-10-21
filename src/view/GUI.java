package view;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

public class GUI extends Scene implements IView {
    public GUI(BorderPane borderPane) {
        super(borderPane, 500,500);
        TilePane tilePane = new TilePane();
        tilePane.setOrientation(Orientation.HORIZONTAL);
        tilePane.setPrefColumns(4);
        tilePane.setVgap(10);
        tilePane.setHgap(10);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setTileAlignment(Pos.CENTER);

        buttonInPane(tilePane,"²");
        buttonInPane(tilePane,"ln()");
        buttonInPane(tilePane,"10^x");
        buttonInPane(tilePane,"C");

        buttonInPane(tilePane,"9");
        buttonInPane(tilePane,"8");
        buttonInPane(tilePane,"7");
        buttonInPane(tilePane,"/");

        buttonInPane(tilePane,"6");
        buttonInPane(tilePane,"5");
        buttonInPane(tilePane,"4");
        buttonInPane(tilePane,"*");

        buttonInPane(tilePane,"3");
        buttonInPane(tilePane,"2");
        buttonInPane(tilePane,"1");
        buttonInPane(tilePane,"-");

        buttonInPane(tilePane,"Back");
        buttonInPane(tilePane,"0");
        buttonInPane(tilePane,"+/-");
        buttonInPane(tilePane,"+");

        borderPane.setTop(tilePane);
    }

    private void buttonInPane(TilePane tilePane, String n){
        Button buttonToAdd = new Button();
        buttonToAdd.setPrefSize(50,50);
        buttonToAdd.setText(n);
        tilePane.getChildren().add(buttonToAdd);
    }
}

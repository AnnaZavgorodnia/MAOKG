package cp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class JavaFXLab1Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 300);
        scene.setFill(Color.rgb(255,215,0));

        Polygon polygon1 = new Polygon(40, 30, 220, 150, 40, 270, 90, 150);
        polygon1.setFill(Color.rgb(0,0,255));
        Polygon polygon2 = new Polygon(420, 100, 340, 150, 420, 200, 380, 150);
        polygon2.setFill(Color.rgb(0,0,255));
        Circle circle = new Circle(140,150,36);
        circle.setFill(Color.rgb(255,0,0));
        Line line = new Line(125, 135, 370, 135);
        Line line2 = new Line(125, 140, 370, 140);
        Line line3 = new Line(125, 145, 370, 145);
        Line line4 = new Line(125, 150, 370, 150);
        Line line5 = new Line(125, 155, 370, 155);
        Line line6 = new Line(125, 160, 370, 160);
        Line line7 = new Line(125, 165, 370, 165);

        root.getChildren().addAll(polygon1, polygon2, circle, line, line2, line3, line4, line5, line6, line7);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

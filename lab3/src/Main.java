import bmp.HeaderBitmapImage;
import bmp.ReadingHeaderFromBitmapImage;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 600);

        MoveTo start = new MoveTo(200, 200);
        HLineTo hLineTo = new HLineTo(300);
        VLineTo vLineTo1 = new VLineTo(250);
        // Top part
        ArcTo bottom = new ArcTo(100, 70, 0, 200, 250, false, true);
        VLineTo vLineTo2 = new VLineTo(200);
        Path drum = new Path();
        drum.setStrokeWidth(1);
        drum.setStroke(Color.BLACK);
        drum.setFill(new LinearGradient(0, 0,
                1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.RED),
                new Stop(0.75, Color.WHITE),
                new Stop(1, Color.RED)));
        drum.getElements().add(start);
        drum.getElements().add(hLineTo);
        drum.getElements().add(vLineTo1);
        drum.getElements().add(bottom);
        drum.getElements().add(vLineTo2);
        root.getChildren().add(drum);

        Ellipse e1 = new Ellipse(233, 187, 5, 5);
        e1.setStrokeWidth(1);
        e1.setStroke(Color.BLACK);
        e1.setFill(Color.BROWN);

        Ellipse e2 = new Ellipse(266, 187, 5, 5);
        e2.setStrokeWidth(1);
        e2.setStroke(Color.BLACK);
        e2.setFill(Color.BROWN);
        root.getChildren().add(e1);
        root.getChildren().add(e2);

        Path p = new Path();
        p.setStrokeWidth(1);
        p.setStroke(Color.BLACK);
        p.setFill(Color.BROWN);
        p.getElements().add(new MoveTo(200, 200));
        p.getElements().add(new LineTo(203, 250));
        p.getElements().add(new ArcTo(3, 3, 0, 197, 250, false, true));
        p.getElements().add(new LineTo(200, 200));
        root.getChildren().add(p);

        Path p1 = new Path();
        p1.setStrokeWidth(1);
        p1.setStroke(Color.BLACK);
        p1.setFill(Color.BROWN);
        p1.getElements().add(new MoveTo(233, 213));
        p1.getElements().add(new LineTo(236, 258));
        p1.getElements().add(new ArcTo(3, 3, 0, 230, 258, false, true));
        p1.getElements().add(new LineTo(233, 213));
        root.getChildren().add(p1);

        Path p2 = new Path();
        p2.setStrokeWidth(1);
        p2.setStroke(Color.BLACK);
        p2.setFill(Color.BROWN);
        p2.getElements().add(new MoveTo(266, 213));
        p2.getElements().add(new LineTo(269, 258));
        p2.getElements().add(new ArcTo(3, 3, 0, 263, 258, false, true));
        p2.getElements().add(new LineTo(266, 213));
        root.getChildren().add(p2);

        Path p3 = new Path();
        p3.setStrokeWidth(1);
        p3.setStroke(Color.BLACK);
        p3.setFill(Color.BROWN);
        p3.getElements().add(new MoveTo(300, 200));
        p3.getElements().add(new LineTo(303, 250));
        p3.getElements().add(new ArcTo(3, 3, 0, 297, 250, false, true));
        p3.getElements().add(new LineTo(300, 200));
        root.getChildren().add(p3);

        Ellipse ellipse = new Ellipse(250, 200, 50, 15);
        ellipse.setStrokeWidth(1);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.YELLOW);
        root.getChildren().add(ellipse);

        Ellipse e11 = new Ellipse(200, 200, 5, 5);
        e11.setStrokeWidth(1);
        e11.setStroke(Color.BLACK);
        e11.setFill(Color.BROWN);

        Ellipse e22 = new Ellipse(233, 213, 5, 5);
        e22.setStrokeWidth(1);
        e22.setStroke(Color.BLACK);
        e22.setFill(Color.BROWN);

        Ellipse e3 = new Ellipse(266, 213, 5, 5);
        e3.setStrokeWidth(1);
        e3.setStroke(Color.BLACK);
        e3.setFill(Color.BROWN);

        Ellipse e4 = new Ellipse(300, 200, 5, 5);
        e4.setStrokeWidth(1);
        e4.setStroke(Color.BLACK);
        e4.setFill(Color.BROWN);
        root.getChildren().add(e11);
        root.getChildren().add(e22);
        root.getChildren().add(e3);
        root.getChildren().add(e4);

        Path p4 = new Path();
        p4.getElements().addAll(
                new MoveTo(200, 130),
                new LineTo(250, 150),
                new ArcTo(10, 10, 0, 248, 155, true, true),
                new LineTo(200, 135),
                new ArcTo(2, 2, 30, 200, 130, false, true)
        );
        p4.setStrokeWidth(1);
        p4.setStroke(Color.BLACK);
        p4.setFill(Color.ORANGE);
        root.getChildren().add(p4);

        Path p5 = new Path();
        p5.getElements().addAll(
                new MoveTo(310, 150),
                new LineTo(260, 190),
                new ArcTo(10, 10, 0, 265, 195, true, false),
                new LineTo(310, 155),
                new ArcTo(2, 2, 0, 310, 150, false, false)
        );
        p5.setStrokeWidth(1);
        p5.setStroke(Color.BLACK);
        p5.setFill(Color.ORANGE);
        root.getChildren().add(p5);

        Path stripe = new Path();
        int xoff = 200;
        int yoff = 200;
        stripe.getElements().addAll(
                // inner
                new MoveTo(xoff, yoff),
                new CubicCurveTo(-30 + xoff, 30 + yoff, -5 + xoff, 39 + yoff, -30 + xoff, 70 + yoff),
                new CubicCurveTo(-40 + xoff, 80 + yoff, -20 + xoff, 122 + yoff, 10 + xoff, 100 + yoff),
                new QuadCurveTo(50 + xoff, 50 + yoff, 90 + xoff, 97 + yoff),
                new CubicCurveTo(-10 + 100 + xoff, 100 + yoff, 40 + 100 + xoff, 130 + yoff, 123 + xoff, 70 + yoff),
                new CubicCurveTo(-10 + 100 + xoff, 30 + yoff, 30 + 100 + xoff, 10 + yoff, 100 + xoff, yoff),
                new CubicCurveTo(130 + xoff, yoff, 110 + xoff, 11 + yoff, 115 + xoff, 45 + yoff),
                new CubicCurveTo(143 + xoff, 70 + yoff, 40 + 100 + xoff, 130 + yoff, -5 + 100 + xoff, 110 + yoff),
                new CubicCurveTo(80 + xoff, 90 + yoff, 50 + xoff, 50 + yoff, 5 + xoff, 110 + yoff),
                new CubicCurveTo(-40 + xoff, 130 + yoff, -43 + xoff, 70 + yoff, -30 + xoff, 53 + yoff),
                new CubicCurveTo(-20 + xoff, 45 + yoff, -20 + xoff, 5 + yoff, xoff, yoff)
        );
        stripe.setStrokeWidth(1);
        stripe.setStroke(Color.BLACK);
        stripe.setFill(new LinearGradient(0, 0,
                0.25, 0, true, CycleMethod.REPEAT,
                new Stop(0, Color.BLUE),
                new Stop(0.75, Color.SKYBLUE),
                new Stop(1, Color.BLUE)));
        root.getChildren().add(stripe);

        //Animation
        int transitionTimeSeconds = 15;

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(transitionTimeSeconds));
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.5);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(transitionTimeSeconds));
        rotateTransition.setByAngle(90);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(transitionTimeSeconds), root);
        scaleTransition.setToX(2);
        scaleTransition.setToY(-1.5);

        PathTransition pathTransition = new PathTransition(Duration.seconds(transitionTimeSeconds), getTrajectoryPath(), root);

        ParallelTransition parallelTransition = new ParallelTransition(root);
        parallelTransition.getChildren().addAll(fadeTransition, scaleTransition, rotateTransition, pathTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.setAutoReverse(true);
        parallelTransition.play();

        primaryStage.setResizable(false);
        primaryStage.setTitle("Lab 3");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private Path getTrajectoryPath() throws IOException {
        int numberOfPixels = 0;

        FileInputStream fileInputStream = new FileInputStream("./sources/trajectory.bmp");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        HeaderBitmapImage image = new ReadingHeaderFromBitmapImage().Reading(bufferedInputStream);
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        int half = (int) image.getHalfOfWidth();

        int let, let1, let2;
        char[][] map = new char[width][height];

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream("pixels.txt"));

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < half; j++) {
                let = reader.read();
                let1 = (let & (0xf0)) >> 4;
                let2 = let & (0x0f);
                if (j * 2 < width) {
                    if (returnPixelColor(let1).equals("BLACK")) {
                        map[j * 2][height - 1 - i] = '1';
                        numberOfPixels++;
                    } else {
                        map[j * 2][height - 1 - i] = '0';
                    }
                }
                if (j * 2 + 1 < width) {
                    if (returnPixelColor(let2).equals("BLACK")) {
                        map[j * 2 + 1][height - 1 - i] = '1';
                        numberOfPixels++;
                    } else {
                        map[j * 2 + 1][height - 1 - i] = '0';
                    }
                }
            }
        }
        reader.close();

        int[][] black = new int[numberOfPixels][2];
        int lich = 0;

        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("map.txt"));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[j][i] == '1') {
                    black[lich][0] = j;
                    black[lich][1] = i;
                    lich++;
                }
                writer.write(map[j][i]);
            }
            writer.write(10);
        }
        writer.close();

        Path path = new Path();
        for (int l = 0; l < numberOfPixels - 1; l++) {
            path.getElements().addAll(new MoveTo(black[l][0], black[l][1]), new LineTo(black[l + 1][0], black[l + 1][1])
            );
        }
        return path;
    }

    private String returnPixelColor(int color) {
        String col = "BLACK";
        switch (color) {
            case 0:
                return "BLACK";     //BLACK;
            case 1:
                return "LIGHTCORAL";  //LIGHTCORAL;
            case 2:
                return "GREEN";     //GREEN
            case 3:
                return "BROWN";     //BROWN
            case 4:
                return "BLUE";      //BLUE;
            case 5:
                return "MAGENTA";   //MAGENTA;
            case 6:
                return "CYAN";      //CYAN;
            case 7:
                return "LIGHTGRAY"; //LIGHTGRAY;
            case 8:
                return "DARKGRAY";  //DARKGRAY;
            case 9:
                return "RED";       //RED;
            case 10:
                return "LIGHTGREEN";//LIGHTGREEN
            case 11:
                return "YELLOW";    //YELLOW;
            case 12:
                return "LIGHTBLUE"; //LIGHTBLUE;
            case 13:
                return "LIGHTPINK";    //LIGHTMAGENTA
            case 14:
                return "LIGHTCYAN";    //LIGHTCYAN;
            case 15:
                return "WHITE";    //WHITE;
        }
        return col;
    }

}

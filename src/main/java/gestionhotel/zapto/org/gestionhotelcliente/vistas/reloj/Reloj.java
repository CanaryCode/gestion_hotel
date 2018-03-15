/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.vistas.reloj;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Reloj {

    private LocalDateTime fechaHora;

    public VBox getReloj() {
        final Circle face = new Circle(100, 100, 100);
        face.setId("face");
        final Label brand = new Label("Tenerife");
        brand.setId("brand");
        brand.layoutXProperty().bind(face.centerXProperty().subtract(brand.widthProperty().divide(2)));
        brand.layoutYProperty().bind(face.centerYProperty().add(face.radiusProperty().divide(2)));
        final Line hourHand = new Line(0, 0, 0, -50);
        hourHand.setTranslateX(100);
        hourHand.setTranslateY(100);
        hourHand.setId("hourHand");
        final Line minuteHand = new Line(0, 0, 0, -75);
        minuteHand.setTranslateX(100);
        minuteHand.setTranslateY(100);
        minuteHand.setId("minuteHand");
        final Line secondHand = new Line(0, 15, 0, -88);
        secondHand.setTranslateX(100);
        secondHand.setTranslateY(100);
        secondHand.setId("secondHand");
        final Circle spindle = new Circle(100, 100, 5);
        spindle.setId("spindle");
        Group ticks = new Group();
        for (int i = 0; i < 12; i++) {
            Line tick = new Line(0, -83, 0, -93);
            tick.setTranslateX(100);
            tick.setTranslateY(100);
            tick.getStyleClass().add("tick");
            tick.getTransforms().add(new Rotate(i * (360 / 12)));
            ticks.getChildren().add(tick);
        }
        final Group analogueClock = new Group(face, brand, ticks, spindle, hourHand, minuteHand, secondHand);
    
        // construct the digitalClock pieces.
        final Label digitalClock = new Label();
        digitalClock.setId("digitalClock");

        // determine the starting time.
        Calendar calendar = GregorianCalendar.getInstance();
        final double seedSecondDegrees = calendar.get(Calendar.SECOND) * (360 / 60);
        final double seedMinuteDegrees = (calendar.get(Calendar.MINUTE) + seedSecondDegrees / 360.0) * (360 / 60);
        final double seedHourDegrees = (calendar.get(Calendar.HOUR) + seedMinuteDegrees / 360.0) * (360 / 12);

        // define rotations to map the analogueClock to the current time.
        final Rotate hourRotate = new Rotate(seedHourDegrees);
        final Rotate minuteRotate = new Rotate(seedMinuteDegrees);
        final Rotate secondRotate = new Rotate(seedSecondDegrees);
        hourHand.getTransforms().add(hourRotate);
        minuteHand.getTransforms().add(minuteRotate);
        secondHand.getTransforms().add(secondRotate);

        // the hour hand rotates twice a day.
        final Timeline hourTime = new Timeline(
                new KeyFrame(
                        Duration.hours(12),
                        new KeyValue(
                                hourRotate.angleProperty(),
                                360 + seedHourDegrees,
                                Interpolator.LINEAR
                        )
                )
        );

        // the minute hand rotates once an hour.
        final Timeline minuteTime = new Timeline(
                new KeyFrame(
                        Duration.minutes(60),
                        new KeyValue(
                                minuteRotate.angleProperty(),
                                360 + seedMinuteDegrees,
                                Interpolator.LINEAR
                        )
                )
        );

        // move second hand rotates once a minute.
        final Timeline secondTime = new Timeline(
                new KeyFrame(
                        Duration.seconds(60),
                        new KeyValue(
                                secondRotate.angleProperty(),
                                360 + seedSecondDegrees,
                                Interpolator.LINEAR
                        )
                )
        );

        // the digital clock updates once a second.
        final Timeline digitalTime = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar calendar = GregorianCalendar.getInstance();
                        String hourString = pad(2, '0', calendar.get(Calendar.HOUR) == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
                        String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
                        String secondString = pad(2, '0', calendar.get(Calendar.SECOND) + "");
                        String ampmString = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                        digitalClock.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );

        // time never ends.
        hourTime.setCycleCount(Animation.INDEFINITE);
        minuteTime.setCycleCount(Animation.INDEFINITE);
        secondTime.setCycleCount(Animation.INDEFINITE);
        digitalTime.setCycleCount(Animation.INDEFINITE);

        // start the analogueClock.
        digitalTime.play();
        secondTime.play();
        minuteTime.play();
        hourTime.play();

        // layout the scene.
        final VBox layout = new VBox();
        layout.getChildren().addAll(analogueClock, digitalClock);
        layout.setAlignment(Pos.CENTER);
        layout.setId("raiz");
      
        return layout;
    }

    private String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
            sb.append(padChar);
        }
        sb.append(s);

        return sb.toString();
    }

    public LocalDateTime getFechaHora() {
        fechaHora = LocalDateTime.now();
        System.out.println(fechaHora);
        return fechaHora;
    }

    // records relative x and y co-ordinates.
    class Delta {

        double x, y;
    }

}

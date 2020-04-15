package Spring2020;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ArrayList<Vehicles> newVehicles = new ArrayList<>();

        //create UI elements
        Label label1 = new Label("1) Add the code required to make this button print out \"Hello\" to the console when it is clicked. (5 points)");
        label1.setWrapText(true);
        Button button1 = new Button("Say Hello");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello");
            }
        });
        button1.setMaxWidth(Double.MAX_VALUE);

        Label label2 = new Label("2) This button should change it's name to \"Clicked\" after you clicked it as well as the number of clicks (how many times had button has been clicked). (10 points)");
        label2.setWrapText(true);
        Button button2 = new Button("Click me");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            int count = 0;
            @Override
            public void handle(ActionEvent actionEvent) {
                if(actionEvent.getSource() == button2){
                    count++;
                    button2.setText("Clicked (" + count + ")");
                }
            }
        });
        button2.setMaxWidth(Double.MAX_VALUE);

        Label label3 = new Label("3) This button generates an error when it is clicked. Fix it! (5 points)");
        label3.setWrapText(true);
        Button button3 = new Button("Click me too");
        button3.setMaxWidth(Double.MAX_VALUE);

        Label label4 = new Label("4) When the button \"New Porsche\" is clicked, a new object of type Porsche with a price of $100000 should be created. The object should be derived from the class Vehicle. The constructor of the class Porsche should print the price of the new Porsche object to the console. The printing should involve the usage of a getter method for the price. This getter method has to be written in the Vehicle class. (20 points)");
        label4.setWrapText(true);
        Button button4 = new Button("New Porsche");
        button4.setMaxWidth(Double.MAX_VALUE);

        Label label5 = new Label("5) When the button \"New Prius\" is clicked, a new object of type Prius with a price of $35000 and a mileage of 54 miles/gallon should be created (using a constructor that accepts the price and mileage as arguments). The object should be derived from the class Vehicle. The constructor should not print anything to the console. (15 points)");
        label5.setWrapText(true);
        Button button5 = new Button("New Prius");
        button5.setMaxWidth(Double.MAX_VALUE);

        Label label6 = new Label("6) Create a button that will add the mileage to the Porsche object created in 4) reading the value form the text field below. The button should read \"Add mileage for Porsche\" and replace the black rectangle. Use a setter medhod to set the mileage for the Porsche object. The setter method has to be written in the Vehicle class. (25 points)");
        label6.setWrapText(true);
        TextField inputField1 = new TextField();
        Button button6 = new Button("Add mileage for Porsche");
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Porsche new1 = new Porsche(100000);
                newVehicles.add(new1);
                button6.setOnAction(new EventHandler<ActionEvent>() {
                    double mlg;
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        mlg = Double.parseDouble(inputField1.getText());
                        new1.setMileage(mlg);
                    }
                });
            }
        });

        button6.setMaxWidth(Double.MAX_VALUE);


        Label label7 = new Label("7) When the button \"Average Mileage\" is pressed, the average mileage for the 2 Vehicle objects created in 4) and 5) should be listed at the console. The calculation should make use of an array or ArrayList  and involve a loop to allow for the possibility to have more Vehicle objects added into the calculation. (10 points)");
        label7.setWrapText(true);
        Button button7 = new Button("Average Mileage");
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double avgmlg = 0;
                for(int i = 0; i < newVehicles.size(); i++)
                {
                    avgmlg += newVehicles.get(i).getMileage();
                }
                System.out.println("The average mileage is: " + (avgmlg/newVehicles.size()));
            }
        });
        button7.setMaxWidth(Double.MAX_VALUE);

        Label label8 = new Label("Bonus) When you click this button, it should open up a dialog box showing the content of a (not yet existing) name field of the Prius object. Only Prius objects should have that field. You need to set the content of the name field before opening the dialog box. (10 bonus points)");
        label8.setWrapText(true);
        Button button8 = new Button("Bonus: Show Prius name");
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Prius new2 = new Prius(35000, 54);
                newVehicles.add(new2);

                button8.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        new2.setName("Bob");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText(new2.getName());
                        alert.showAndWait();
                    }
                });
            }
        });
        button8.setMaxWidth(Double.MAX_VALUE);

        //setup inner grid pane layout
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: lightblue;");
        gridPane.setHgap(10);
        gridPane.setVgap(12);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(80);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        gridPane.getColumnConstraints().addAll(col1, col2);

        //add UI elements to inner layout
        gridPane.add(label1, 0, 0, 1, 1);
        gridPane.add(button1, 1, 0, 1, 1);
        gridPane.add(label2, 0, 1, 1, 1);
        gridPane.add(button2, 1, 1, 1, 1);
        gridPane.add(label3, 0, 2, 1, 1);
        gridPane.add(button3, 1, 2, 1, 1);
        gridPane.add(label4, 0, 3, 1, 1);
        gridPane.add(button4, 1, 3, 1, 1);
        gridPane.add(label5, 0, 4, 1, 1);
        gridPane.add(button5, 1, 4, 1, 1);
        gridPane.add(label6, 0, 5, 1, 1);
        gridPane.add(button6, 1, 5, 1, 1);
        gridPane.add(inputField1, 0, 6, 1, 1);
        gridPane.add(label7, 0, 7, 1, 1);
        gridPane.add(button7, 1, 7, 1, 1);
        gridPane.add(label8, 0, 8, 1, 1);
        gridPane.add(button8, 1, 8, 1, 1);

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int[] myarray = {3, 4, 5, 6};

                for (int i = 0; i < 4; i++) {
                    System.out.println(myarray[i]);
                }
            }
        });


        //setup outer layout
        BorderPane border = new BorderPane();
        HBox top = new HBox();
        top.setPadding(new Insets(0, 0, 10, 10));
        Label topLabel1 = new Label("INSTRUCTIONS: ");
        topLabel1.setStyle("-fx-font: normal bold 20px 'arial' ");
        topLabel1.setMinWidth(Region.USE_PREF_SIZE);
        Label topLabel2 = new Label("Write code to implement the functionality described next to the buttons or other UI elements. You can assume that the buttons will be pressed in order. (Max total points: 90 without bonus)");
        topLabel2.setWrapText(true);
        top.getChildren().addAll(topLabel1, topLabel2);
        border.setTop(top);
        border.setCenter(gridPane);
        border.setPadding(new Insets(20, 20, 20, 20));
        //add layout to scene and stage
        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CIS 2348 Homework 4 Spring 2020");
        primaryStage.setWidth(800);
        primaryStage.setHeight(700);
        primaryStage.show();
    }
}

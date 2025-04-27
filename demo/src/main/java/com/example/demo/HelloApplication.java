package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements IMVPContract.View {

    private TextField tf_nameField;
    private TextField tf_ageField;
    private TextField tf_lastname;
    private Label label_numPeople;
    private Label label_found;

    // The view only needs to have an object that implements the
    // Presenter contract....  notice the type here.
    IMVPContract.Presenter myPresenter;

    @Override
    public void start(Stage stage) throws IOException {

        // //////////////////////////////////////////////////////////////
        // We have to actually have a presenter so we create a specific one
        // here that implements the correct interface.  Presenters could be
        // provided in some other way, but this is convenient for our purposes
        // and works well.
        myPresenter = new PersonPresenter(this);

        // The stage is the "window"
        // Sets the title of your window
        stage.setTitle("JavaFX MVP Demo");

        // Create a Label and TextFields for name and age
        Label messageLabel = new Label("Enter your name and age:");
        tf_nameField = new TextField();
        tf_nameField.setPromptText("Enter your First name");
        tf_lastname = new TextField();
        tf_lastname.setPromptText("Enter last name");// Optional placeholder text
        tf_ageField = new TextField();
        tf_ageField.setPromptText("Enter your age");

        CheckBox cb = new CheckBox("Check This!");
        cb.setOnAction(this::cbChecked);

        Label label_peopleInDB = new Label("Num People: ");
        label_numPeople = new Label("0");

        // Create a Submit button
        Button submitButton = new Button("Add Person to DB");
        submitButton.setOnAction(this::buttonClicked);

        Button search = new Button("Search person");
        search.setOnAction(this::buttonSearch);


        label_found = new Label("0");

        VBox vboxPane = new VBox(10);
        vboxPane.setPadding(new Insets(20, 30, 20, 30));
        vboxPane.getChildren().addAll(messageLabel, tf_nameField,tf_lastname, tf_ageField, cb, submitButton, label_peopleInDB, label_numPeople, search, label_found);

        // The Scene (or SceneGraph) in JavaFX contains everything that will
        // be rendered and shown.  Add the pane to it via the constructor call.
        // and then let the stage know about the scene.
        Scene scene = new Scene(vboxPane);
        stage.setScene(scene);

        // this results in the stage being rendered
        stage.show();
    }

    public void buttonSearch(ActionEvent event){
        myPresenter.searchPerson(tf_nameField.getText());
    }
    public void buttonClicked(ActionEvent event)
    {
        // This is an event that we need to react to.  When the button is clicked
        // pass along the information in some useable form (Strings in this case)
        // to the presenter to do the work for us.
        myPresenter.addPersonToDB( tf_nameField.getText(), tf_lastname.getText(), tf_ageField.getText() );
    }

    @Override
    public void updateSearch(String l) {
        label_found.setText(l);
    }

    // All views that implement this contract for this app, must be able to update
    // the number of people in the DB on the GUI.  This does that for our JavaFX Label.
    @Override
    public void updateNumberInDB( int num ) {
        // This function will get called with an int, so convert to a String here
        // since that's what we need for this GUI's label.
        label_numPeople.setText( Integer.toString(num) );
    }

    public void cbChecked(ActionEvent event) {
        System.out.println(event.toString());
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.noah.Main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	  private Map<String, Integer>[] boyMap = new HashMap[10];
	  private Map<String, Integer>[] girlMap = new HashMap[10];
	  
	  private Button btFindRanking = new Button("Find Ranking");
	  private ComboBox<Integer> cboYear = new ComboBox<>();
	  private ComboBox<String> cboGender = new ComboBox<>();
	  private TextField tfName = new TextField();
	  private Label lblResult = new Label();
	  
	  private int year = 2001;
	  private String gender = "Male";
	  
	  @Override
	  public void start(Stage primaryStage) throws IOException {
	    GridPane gridPane = new GridPane();
	    gridPane.add(new Label("Select a year:"), 0, 0);
	    gridPane.add(new Label("Boy or girl?"), 0, 1);
	    gridPane.add(new Label("Enter a name:"), 0, 2);
	    gridPane.add(cboYear, 1, 0);
	    gridPane.add(cboGender, 1, 1);
	    gridPane.add(tfName, 1, 2);
	    gridPane.add(btFindRanking, 1, 3);
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	  
	    BorderPane borderPane = new BorderPane();
	    borderPane.setCenter(gridPane);
	    borderPane.setBottom(lblResult);
	    BorderPane.setAlignment(lblResult, Pos.CENTER);

	    // Create a scene and place it in the stage
	    Scene scene = new Scene(borderPane, 370, 160);
	    primaryStage.setTitle("Exercise21_11"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage

	    for (int year = 2001; year <= 2010; year++) {
	      cboYear.getItems().add(year);
	    }
	    cboYear.setValue(2001);
	        
	    cboGender.getItems().addAll("Male", "Female");
	    cboGender.setValue("Male");
	    
	    cboYear.setOnAction((event) -> {
	    	year = cboYear.getSelectionModel().getSelectedItem();
	    	
	    	System.out.println(year);
	    });
	    
	    cboGender.setOnAction((event) -> {
	    	gender = cboGender.getSelectionModel().getSelectedItem();
	    	System.out.println(gender);
	    });
	    btFindRanking.setOnAction((event) -> {
	    	if(gender.equalsIgnoreCase("male")) {
	    		Boolean exists = false;
		    	for(Map.Entry<String, Integer> pair : boyMap[year - 2001].entrySet()) {
		    		if(pair.getKey().toString().equalsIgnoreCase(tfName.getCharacters().toString())) {
		    			lblResult.setText("Ranking: " + pair.getValue());
		    			exists = true;
		    		}
		    		if(exists == false) {
		    			lblResult.setText("Ranking: not found");
		    		}
		    	}
	    	} else {
	    		Boolean exists = false;
		    	for(Map.Entry<String, Integer> pair : girlMap[year - 2001].entrySet()) {
		    		if(pair.getKey().toString().equalsIgnoreCase(tfName.getCharacters().toString())) {
		    			lblResult.setText("Ranking: " + pair.getValue());
		    			exists = true;
		    		}
		    		if(exists == false) {
		    			lblResult.setText("Ranking: not found");
		    		}
		    	}
	    	}
	    });
	    
	    System.out.println(year);
	    System.out.println(gender);
	    
	    for(int i = 0; i <= 9; i++) {
		    URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2001 + i) + ".txt");
		    
			Scanner sc = new Scanner(url.openStream());
			
			boyMap[i] = new HashMap();
			girlMap[i] = new HashMap();
			while(sc.hasNext()) {
				
				int ranking = sc.nextInt();		
				String boyName = sc.next();
				sc.nextInt();
				String girlName = sc.next();
				sc.nextInt();
				
				
				boyMap[i].put(boyName, ranking);
				girlMap[i].put(girlName, ranking);
			}
			
	    }
	  }

	  /**
	   * The main method is only needed for the IDE with limited
	   * JavaFX support. Not needed for running from the command line.
	 * @throws IOException 
	   */
	  public static void main(String[] args) throws IOException {
	    launch(args);
	  }
}

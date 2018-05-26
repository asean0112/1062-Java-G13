package ca2;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.fxml.FXML;


/**
 * 
 * @author Sean
 * @version 26/05/2018
 */
public class MainMenu {

	
	@FXML
	private Parent  root;
	@FXML
	private Button newGame, resumeGame, help, exit;
	String gameType;
	static game classic;
	static gameAlternative alternative;
	Stage primaryStage;
	
	public MainMenu (String gameType) {
		this.gameType = gameType;
		primaryStage = new Stage();
	
		try {
			 root = FXMLLoader.load(MainMenu.class.getResource("/Main Menu.fxml"));
		} catch (IOException e) {e.printStackTrace();}
			 	
				
		newGame = (Button)root.lookup("#newGame");
		resumeGame = (Button)root.lookup("#resumeGame");
		help = (Button)root.lookup("#help");
		exit = (Button)root.lookup("#exit");
				
		Scene scene = new Scene(root,550,375);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(MainMenu.class.getResourceAsStream("/icon.png")));
		primaryStage.setTitle("Main Menu");
		primaryStage.show();
		
//		
//		newGame.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent arg0) {
//				switch (gameType){
//				case "classic":
//					classic = new game(primaryStage);
//					break;
//				case "alternative":
//					alternative = new gameAlternative(primaryStage);
//					break;
//				}
//				primaryStage.close();	
//		}});
			
				
		resumeGame.setOnAction(new EventHandler<ActionEvent>(){
			ObjectInputStream objectInputStream;
			@Override
			public void handle(ActionEvent arg0) { // to resume the saved game
				try {
					switch (gameType){
					case "classic":
						
					break;
					case "alternative":
											break;
					}
					primaryStage.close();
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.INFORMATION, "Last game has not been found", ButtonType.OK);
					alert.showAndWait();
		}}});
				
				
		help.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				helpWindow(primaryStage);
		}});
					
				
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.close();
		}});		
	}
	
	
	
	public void helpWindow(Stage primaryStage){
		primaryStage = new Stage();
		//primaryStage.getIcons().add(new Image(MainMenu.class.getResourceAsStream("/icon.png")));
		Scene scene = null;
		try {
			scene = new Scene(FXMLLoader.load(game.class.getResource("/Help.fxml")), 600,400);
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.setScene(scene);
		primaryStage.setTitle("Help");
		primaryStage.show();	
	}
	

	public game getClassic() {
		return classic;
	}

	public gameAlternative getAlternative() {
		return alternative;
	}

	
}

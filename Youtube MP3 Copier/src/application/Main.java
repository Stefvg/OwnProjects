package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(25, 25, 25, 25));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			addTitle(root);
			addButton(root);
			
			primaryStage.setTitle("Youtube MP3 copier");
			primaryStage.getIcons().add(new Image("icon.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void addTitle(GridPane root) {
		Label label = new Label("Youtube MP3 copier");
		root.add(label, 0, 1);
	}
	
	private void addButton(GridPane root) {
		Button btn = new Button();
        btn.setText("Kopiëer muziek naar iTunes");
		btn.setOnAction(new MusicCopier());
        root.add(btn, 0, 2);
        
	}
	
}

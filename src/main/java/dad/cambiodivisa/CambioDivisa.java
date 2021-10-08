package dad.cambiodivisa;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CambioDivisa extends Application {
    private TextField origenText;
    private TextField destinoText;
	private ComboBox<Divisa> OrigenBox;
	private ComboBox<Divisa> DestinoBox;
	private ObjectProperty<Divisa> origen = new SimpleObjectProperty<>();
	private ObjectProperty<Divisa> destino = new SimpleObjectProperty<>();
	private Button cambiar;

	@Override
	public void start(Stage primaryStage) throws Exception {
		origenText=new TextField();
		destinoText=new TextField();
		destinoText.setEditable(false);
		cambiar=new Button("Cambiar");
		OrigenBox = new ComboBox<>();
		OrigenBox.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Libra", 0.8873),
				new Divisa("Dolar", 1.2007),
				new Divisa("Yen", 133.59)
			);
		OrigenBox.getSelectionModel().selectFirst();
		
		DestinoBox = new ComboBox<>();
		DestinoBox.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Libra", 0.8873),
				new Divisa("Dolar", 1.2007),
				new Divisa("Yen", 133.59)
			);
		DestinoBox.getSelectionModel().selectLast();
	
		VBox root = new VBox(5, 
				new HBox(5,origenText,OrigenBox), 
				new HBox(5,destinoText,DestinoBox),
				cambiar
			);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Cambio Divisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		origen.bind(OrigenBox.getSelectionModel().selectedItemProperty());
		destino.bind(DestinoBox.getSelectionModel().selectedItemProperty());
		
		cambiar.setOnAction(e -> onCalcularDivisa(e));
		cambiar.setDefaultButton(true);
	}


	private void onCalcularDivisa(ActionEvent e) {
		try {
			double Cantidad=Double.valueOf(origenText.getText());
			destinoText.setText(""+Divisa.fromTo(origen.get(),destino.get(),Cantidad));	
		} catch (Exception e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cambio Divisa");
			alert.setHeaderText("¡Error!");
			alert.setContentText("El valor "+origenText.getText()+" no es valido");
			alert.showAndWait();
			
		}
		
	}
	


	public static void main(String[] args) {
		launch(args);
	}

}

package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;;

public class Main extends Application {
	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.9);
	private Divisa dolar = new Divisa("Dolar", 1.17);
	private Divisa yen = new Divisa("Yen", 124.17);

	private Divisa[] divisas = { euro, libra, dolar, yen };
	private TextField origenText, destinoText;
	private ComboBox<Divisa> origenCombo, destinoCombo;
	private Button cambiarButton;

	public void start(Stage primaryStage) {
		origenText = new TextField("0");
		origenText.setPrefColumnCount(4);
		destinoText = new TextField("0");
		destinoText.setPrefColumnCount(4);

		// Origen
		origenCombo = new ComboBox<>();
		origenCombo.getItems().addAll(divisas);
		origenCombo.getSelectionModel().selectFirst();

		HBox origenBox = new HBox();
		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origenText, origenCombo);

		// Destino
		destinoCombo = new ComboBox<>();
		destinoCombo.getItems().addAll(divisas);
		destinoCombo.getSelectionModel().selectFirst();

		HBox destinoBox = new HBox();
		destinoBox.setAlignment(Pos.BASELINE_CENTER);
		destinoBox.setSpacing(5);
		destinoBox.getChildren().addAll(destinoText, destinoCombo);

		// Boton
		cambiarButton = new Button("Cambiar");
		cambiarButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int numeroOrigen = Integer.parseInt(origenText.getText());
				double operacion;
				String resultado = "";
				// Convertir de euros a..
				if (origenCombo.getValue() == divisas[0]) {
					Divisa valor = destinoCombo.getValue();
					if (valor == divisas[0]) {
						operacion = numeroOrigen * 1;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[1]) {
						operacion = numeroOrigen * 0.9;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[2]) {
						operacion = numeroOrigen * 1.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[3]) {
						operacion = numeroOrigen * 124.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
				}

				// Convertir de libras a..
				if (origenCombo.getValue() == divisas[1]) {
					Divisa valor = destinoCombo.getValue();
					if (valor == divisas[0]) {
						operacion = numeroOrigen / 0.9;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[1]) {
						operacion = numeroOrigen * 1;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[2]) {
						operacion = (numeroOrigen * 1.17) / 0.9;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[3]) {
						operacion = (numeroOrigen * 124.17) / 0.9;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
				}

				// Convertir de dolar a..
				if (origenCombo.getValue() == divisas[2]) {
					Divisa valor = destinoCombo.getValue();
					if (valor == divisas[0]) {
						operacion = numeroOrigen / 1.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[1]) {
						operacion = (numeroOrigen * 0.9) / 1.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[2]) {
						operacion = numeroOrigen * 1;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[3]) {
						operacion = (numeroOrigen * 124.17) / 1.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
				}

				// Convertir de Yen a..
				if (origenCombo.getValue() == divisas[3]) {
					Divisa valor = destinoCombo.getValue();
					if (valor == divisas[0]) {
						operacion = numeroOrigen / 124.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[1]) {
						operacion = (numeroOrigen * 0.9) / 124.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[2]) {
						operacion = (numeroOrigen * 1.17) / 124.17;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
					if (valor == divisas[3]) {
						operacion = numeroOrigen * 1;
						resultado = operacion + "";
						destinoText.setText(resultado);
					}
				}

			}
		});

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(origenBox, destinoBox, cambiarButton);
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Cambio de divisa");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

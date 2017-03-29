package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> cmbLanguage;

	@FXML
	private TextArea txtTesto;

	@FXML
	private Button btnSpellCheck;

	@FXML
	private TextArea txtResult;

	@FXML
	private Label txtErrors;

	@FXML
	private Button btnClearText;

	@FXML
	private Label txtTime;

	private Dictionary dizionario;

	@FXML
	void doClearText(ActionEvent event) {

		txtTesto.clear();
		txtResult.clear();

	}

	@FXML
	void doSpellCheck(ActionEvent event) {

		long inizio = System.nanoTime();

		String lingua = cmbLanguage.getValue();

		if (!txtTesto.getText().isEmpty()) {

			String[] parole = txtTesto.getText().split(" ");

			List<String> testo = new ArrayList<>(dizionario.controllaParole(parole, lingua));

			for (String string : testo) {
				txtResult.appendText(string + "\n");
			}

		}

		long fine = System.nanoTime();
		long delta = fine - inizio;

		txtErrors.setText("The text contains " + dizionario.contaErrori() + " errors");
		txtTime.setText("Spell check completed in " + delta/10e9 + " seconds");
		
		dizionario.clearSbagliate();

	}

	@FXML
	void initialize() {
		assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

		cmbLanguage.getItems().addAll("Italiano","English");
	}

	public void setModel(Dictionary dizionario) {
		this.dizionario = dizionario;

	}
}

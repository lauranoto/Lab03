package it.polito.tdp.spellchecker.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

	private List<String> words;
	private List<String> parole;
	

	public Dictionary() {
		
		this.words = new ArrayList<>();
		this.parole = new ArrayList<>();
	}

	public void loadDictionary(String language) {

		if (language == "English") {
			try {
				ArrayList<String> lines = new ArrayList<>();

				lines.addAll(Files.readAllLines(Paths.get("rsc/English.txt")));

				for (String line : lines) {

					if (!line.isEmpty()) {

						words.add(line);
					}
				}
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
		
		if (language== "Italiano") {
			try {
				ArrayList<String> lines = new ArrayList<>();

				lines.addAll(Files.readAllLines(Paths.get("rsc/Italian.txt")));

				for (String line : lines) {

					if (!line.isEmpty()) {

						parole.add(line);
					}
				}
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}

	}

	public List<RichWord> spellCheckText(List<String> inputTextList) {
		
		List<RichWord> risultato = new ArrayList<>();
		
		for (String string : inputTextList) {
			
		}
		
		return risultato;
	}

}

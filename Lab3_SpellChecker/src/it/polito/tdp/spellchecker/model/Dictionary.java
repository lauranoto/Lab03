package it.polito.tdp.spellchecker.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dictionary {

	private List<String> words;
	private List<String> parole;
	private List<String> sbagliate;

	public Dictionary() {

		this.words = new ArrayList<>();
		this.parole = new ArrayList<>();
		this.sbagliate = new ArrayList<>();
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

		if (language == "Italiano") {
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

	public Collection<String> controllaParole(String[] parole, String lingua) {
		
		
		if (lingua == "English") {
			
			for (String string : parole) {
				
				if (!words.contains(string)) {
					
					sbagliate.add(string);
					
				}
			}
		}
		
	if (lingua == "Italiano") {
			
			for (String string : parole) {
				
				if (!this.parole.contains(string)) {
					
					sbagliate.add(string);
					
				}
			}
		}
		
		return sbagliate;
		
	}

	public int contaErrori() {
		return sbagliate.size();
	}

	public void clearSbagliate() {
		sbagliate.clear();
		
	}
	
	

}

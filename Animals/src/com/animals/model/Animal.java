package com.animals.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	
	private  int animalName;
	
	private  String animalVisualFile;
	
	private ArrayList<String> animalAudioFile;
	
	private List<Integer> animalNames;
	
	public int getAnimalName(int code) {
		return animalNames.get(code);
	}

	public void addAnimalName(int animalName) {
		if(animalNames == null){
			animalNames = new ArrayList<Integer>();
		}
		animalNames.add(animalName);
	}

	public String getAnimalVisualFile() {
		return animalVisualFile;
	}

	public void setAnimalVisualFile(String animalVisualFile) {
		this.animalVisualFile = animalVisualFile;
	}

	public ArrayList<String> getAnimalAudioFile() {
		return animalAudioFile;
	}

	public void setAnimalAudioFile(ArrayList<String> animalAudioFile) {
		this.animalAudioFile = animalAudioFile;
	}
	
	public void addAudioFile(String fileName){
		if(animalAudioFile == null){
			animalAudioFile = new ArrayList<String>();
			
		}
		animalAudioFile.add(fileName);
	}
	

	

}

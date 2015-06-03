package com.animals.model;

import java.util.ArrayList;

public class Animal {
	
	private  int animalName;
	
	private  String animalVisualFile;
	
	private ArrayList<String> animalAudioFile;

	public int getAnimalName() {
		return animalName;
	}

	public void setAnimalName(int animalName) {
		this.animalName = animalName;
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

package com.greninjaCSV.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;

public class CSVFileReader {

	public static void main(String[] args) {
		String delimeter = ";";
		String lineData;
		File csvFile = new File("input-data.csv");
		
		try {
			BufferedReader read = new BufferedReader(new FileReader(csvFile));
			JSONArray arrayOfJSONObjects = new JSONArray();
			
			while((lineData = read.readLine()) != null) {
				String[] moeda = lineData.split(delimeter);
				
				System.out.println("[ID Transição = " + moeda[0]
						+ " , Data Transição = "      + moeda[1]
						+ " , Documento = "           + moeda[2]
						+ " , Nome = "                + moeda[3]
						+ " , Idade = "               + moeda[4]
						+ " , Valor = "               + moeda[5]
						+ " , Num Parcelas = "        + moeda[6] + "]");
				
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("ID Transição",   moeda[0]);
				jsonObj.put("Data Transição", moeda[1]);
				jsonObj.put("Documento",      moeda[2]);
				jsonObj.put("Nome",           moeda[3]);
				jsonObj.put("Idade",          moeda[4]);
				jsonObj.put("Valor",          moeda[5]);
				jsonObj.put("Num Parcelas",   moeda[6]);
				
				arrayOfJSONObjects.put(jsonObj);
				
			}
			
			try(PrintWriter out = new PrintWriter(new FileWriter("dadosJSON.txt"))){
				out.write(arrayOfJSONObjects.toString());
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}

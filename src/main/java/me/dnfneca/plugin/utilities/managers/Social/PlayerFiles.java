package me.dnfneca.plugin.utilities.managers.Social;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class PlayerFiles {
	public static void CreatePlayerFile(String PlayerUUID) {
		if(new File("./plugins/MMORPGData/Players/" + PlayerUUID + ".json").exists()){
			return;
		}
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("class", "none");
			FileWriter fileWriter = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json");
			fileWriter.write(jsonObject.toJSONString());
			fileWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	public static void SaveToPlayerFile(String PlayerUUID, String fieldName, Object fieldData) {
		try {
			File f = new File("./plugins/MMORPGData/Players/" + PlayerUUID + ".json");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(fieldName, fieldData);
			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);
			file.write(jsonObject.toString());
			file.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void AddDataToPlayerFile(String PlayerUUID, String fieldName, Object fieldData) {
		try {
			if(FieldExists(PlayerUUID, fieldName)) {
				AddToPlayerField(PlayerUUID, fieldName, fieldData);
				return;
			}
			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			fileData.put(fieldName, fieldData);
			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);
			file.append(fileData.toJSONString());
			file.close();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static void AddDataToPlayerFieldFile(String PlayerUUID, String fieldName, Object fieldData) {
		String data1 = String.valueOf(fieldData);
		String[] dataArray = data1.split(" ");
		String replaceWith = fieldData.toString().split(" ")[0];
		try {

			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			Object data = fileData.get(fieldName);
			String finalData = fileData.toString();
			System.out.println(finalData);

			String[] arrays = data.toString().split(",");


			for (int i = 0; i<arrays.length; i++) {
				String individual = arrays[i].split(" ")[0];
				if(!individual.equals(replaceWith)) {
					fileData.put(fieldName, (fieldData + "," + individual + " " + arrays[i].split(" ")[1]));
				}
			}
			System.out.println(fileData);

			finalData = fileData.toString();

			for (int i = 0; i<arrays.length; i++) {
				String individual = arrays[i].split(" ")[0];
				if(individual.equals(replaceWith)) {
					finalData.replace(arrays[i], fieldData.toString());
				}
			}

			System.out.println(finalData);



			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);
			file.append(finalData);
			file.close();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
	public static void AddToPlayerField(String PlayerUUID, String fieldName, Object fieldData) {
		String data1 = String.valueOf(fieldData);
		String[] dataArray = data1.split(" ");
		String addTo = fieldData.toString().split(" ")[0];
		try {

			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			Object data = fileData.get(fieldName);
			String finalData = fileData.toString();
			System.out.println(finalData);

			String[] arrays = data.toString().split(",");
			String all = "";


			String new1 = "";
			for (int i = 0; i<arrays.length; i++) {
				String individual = arrays[i].split(" ")[0];
				if(individual.equals(addTo)) {
					System.out.println("aeae");
					new1 = fieldData.toString().split(" ")[0] + " " + (Integer.parseInt(fieldData.toString().split(" ")[1]) + Integer.parseInt(arrays[i].split(" ")[1]));
					break;
				}
			}
			all = all.concat(new1 + ",");
			for (int i = 0; i<arrays.length; i++) {
				String individual = arrays[i].split(" ")[0];
				if(!individual.equals(addTo)) {
					all = all.concat(arrays[i]);
				}
			}
			System.out.println(fileData);

			fileData.remove(fieldName);
			fileData.put(fieldName, all);

			finalData = fileData.toString();

			System.out.println((Integer.parseInt(fieldData.toString().split(" ")[1]) + Integer.parseInt(arrays[1].split(" ")[1])));




			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);
			file.append(finalData);
			file.close();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}



	public static String[] LoadPlayerFile(String PlayerUUID) {
			try {
				JSONParser parser = new JSONParser();
				JSONObject fileData = (JSONObject) parser.parse(
						new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
				Collection values = fileData.values();
				String edit1 = values.toString().replace("[", "").replace("]", "").replace("\"", "");
				String[] array = edit1.split(",");
				return array;
			} catch (IOException | ParseException e) {
				throw new RuntimeException(e);
			}
	}


	public static String[] GetPlayerFileField(String PlayerUUID, String FieldName) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			return fileData.get(FieldName).toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static void ReplaceExistingPlayerDataToFile(String PlayerUUID, String newData, String oldDataKey) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.
			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);

			fileData.remove(oldDataKey);
			fileData.put(oldDataKey, newData);

			file.write(String.valueOf(fileData));
			file.close();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean FieldExists(String PlayerUUID, String dataFieldKey) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject fileData = (JSONObject) parser.parse(
					new FileReader("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8));//path to the JSON file.

			if(fileData.get(dataFieldKey) != null) {
				return true;
			} else {
				return false;
			}
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
}

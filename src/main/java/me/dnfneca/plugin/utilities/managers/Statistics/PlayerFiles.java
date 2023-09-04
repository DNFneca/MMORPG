package me.dnfneca.plugin.utilities.managers.Statistics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(fieldName, fieldData);
			FileWriter file = new FileWriter("./plugins/MMORPGData/Players/" + PlayerUUID + ".json", StandardCharsets.UTF_8);
			file.append(jsonObject.toString());
			file.close();
		} catch (IOException e) {
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
			return fileData.get(FieldName).toString().replace("[", "").replace("]", "").replace("\"", "").replace(" ", "").split(",");
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

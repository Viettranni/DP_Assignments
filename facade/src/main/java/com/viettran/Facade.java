package com.viettran;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Facade {
    
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException {
        String json = fetchJsonFromUrl(urlString);
        return parseAttributeFromJson(json, attributeName);
    }

    private String fetchJsonFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to connect: HTTP status code " + status);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        } finally {
            con.disconnect();
        }
    }

    private String parseAttributeFromJson(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json);

            if (obj instanceof JSONObject) {
                return parseFromJsonObject((JSONObject) obj, attributeName);
            } else if (obj instanceof JSONArray) {
                return parseFromJsonArray((JSONArray) obj, attributeName);
            } else {
                throw new IllegalArgumentException("Invalid JSON structure.");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }

    private String parseFromJsonObject(JSONObject jsonObject, String attributeName) {
        String[] keys = attributeName.split("\\.");
        JSONObject nestedObject = jsonObject;

        for (String key : keys) {
            if (nestedObject.containsKey(key)) {
                Object value = nestedObject.get(key);
                if (value instanceof JSONObject) {
                    nestedObject = (JSONObject) value;
                } else {
                    return value != null ? value.toString() : null;
                }
            } else {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
            }
        }

        return null;
    }

    private String parseFromJsonArray(JSONArray jsonArray, String attributeName) {
        try {
            int index = Integer.parseInt(attributeName.split("\\.")[0]);
            if (index >= jsonArray.size()) {
                throw new IllegalArgumentException("Index out of bounds.");
            }

            JSONObject jsonObject = (JSONObject) jsonArray.get(index);
            return parseFromJsonObject(jsonObject, attributeName.substring(attributeName.indexOf('.') + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid index in attribute name.");
        }
    }
}

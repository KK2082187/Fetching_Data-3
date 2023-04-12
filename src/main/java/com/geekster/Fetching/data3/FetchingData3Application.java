package com.geekster.Fetching.data3;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class FetchingData3Application {

	public static void main(String[] args) throws Exception {

		URL getUrl = new URL("https://api.nationalize.io/?name=nathaniel");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");


		int responseCode = connection.getResponseCode();

		if (responseCode == 200) {


			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonResponseData = new StringBuilder();
			String readLine = null;


			while ((readLine = in.readLine()) != null) {
				jsonResponseData.append(readLine);
			}

			in.close();
			JSONObject masterData = new JSONObject(jsonResponseData.toString());
			System.out.println(masterData);

		} else {
			System.out.println("This is not valid URL- " + responseCode);
		}

	}

}

package org.astashonok.service.impl;

import org.astashonok.service.CountryService;
import org.astashonok.util.Serializer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    // path to GeoNames web service to get the all countries
    private static final String PATH_TO_GEO_NAMES_FROM_WEB = "http://api.geonames.org/countryInfo?username=shajedulislam";
    // The file with country names
//    private File file = new File(Objects
//            .requireNonNull(getClass().getClassLoader().getResource("countryNames.bs")).getFile());

    public CountryServiceImpl() throws FileNotFoundException {
    }

    @Override
    public List<String> getAll() {
        return getCountryNamesFromInternet();
    }

    private List<String> getCountryNamesFromFile() {
        String[] s = Serializer.read("src/main/resources/countryNames.bs");
        return Arrays.asList(s);
    }

    private List<String> getCountryNamesFromInternet() {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(PATH_TO_GEO_NAMES_FROM_WEB);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                builder.append(output);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(builder.toString());
        JSONArray listCountries = jsonObject.getJSONArray("geonames");
        for (int i = 0; i < listCountries.length(); i++) {
            JSONObject country = listCountries.getJSONObject(i);
            String countryName = country.getString("countryName");
            list.add(countryName);
        }
        return list;
    }
}

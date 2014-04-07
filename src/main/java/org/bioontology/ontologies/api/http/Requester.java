package org.bioontology.ontologies.api.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author palexand
 */
public class Requester {

    private final String restScheme;
    private final String restHost;
    private final String apikey;

    public Requester(HTTPOptions opts) {
        restScheme = opts.getRestScheme();
        restHost = opts.getRestHost();
        apikey = opts.getApikey();
    }

    public String get(String path) {
        return get(path, "", apikey);
    }

    public String get(String path, Map<String, String> urlParameters) {
        return get(path, mapToParams(urlParameters), apikey);
    }

    public String get(String path, String urlParameters) {
        return get(path, urlParameters, apikey);
    }

    public String get(String path, String urlParameters, String apikey) {
        URI uri;
        try {
            uri = new URI(restScheme, restHost, path, urlParameters, "");
            return get(uri);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String get(URI uri) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = uri.toURL();
            Logger.getLogger(Requester.class.getName()).log(Level.FINER, null, "GET to:\n" + url);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "apikey token=" + apikey);
            conn.setRequestProperty("Accept", "application/json");
            conn.setUseCaches(true);
            rd = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public String post(String path, Map<String, String> urlParameters) {
        return get(path, mapToParams(urlParameters), apikey);
    }

    public String post(String path, String urlParameters, String apikey) {
        URL url;
        HttpURLConnection conn;

        String line;
        String result = "";
        try {
            URI uri = new URI(restScheme, restHost, path);
            url = uri.toURL();
            Logger.getLogger(Requester.class.getName()).log(Level.FINER, null, "POST to:\n" + url);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "apikey token=" + apikey);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }
            conn.disconnect();

            try (BufferedReader rd = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                while ((line = rd.readLine()) != null) {
                    result += line;
                }
            }
        } catch (IOException | URISyntaxException e) {
            Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, e);
        }

        return result;
    }

    private String mapToParams(Map<String, String> parameters) {
        List params = new ArrayList<>();
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                params.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Requester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return StringUtils.join(params, "&");
    }

}

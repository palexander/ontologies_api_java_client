package org.bioontology.ontologies.api.http;

/**
 *
 * @author palexand
 */
public class HTTPOptions {

    private String apikey;
    private String restScheme;
    private String restHost;

    public HTTPOptions(String newApikey) {
        restScheme = "http";
        restHost = "data.bioontology.org";
        apikey = newApikey;
    }

    public HTTPOptions(String newApikey, String newRestHost) {
        restScheme = "http";
        restHost = newRestHost;
        apikey = newApikey;
    }

    public HTTPOptions(String newApikey, String newRestHost, String newRestScheme) {
        restScheme = newRestScheme;
        restHost = newRestHost;
        apikey = newApikey;
    }

    /**
     * @return the apikey
     */
    public String getApikey() {
        return apikey;
    }

    /**
     * @param apikey the apikey to set
     */
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    /**
     * @return the restScheme
     */
    public String getRestScheme() {
        return restScheme;
    }

    /**
     * @param restScheme the restScheme to set
     */
    public void setRestScheme(String restScheme) {
        this.restScheme = restScheme;
    }

    /**
     * @return the restHost
     */
    public String getRestHost() {
        return restHost;
    }

    /**
     * @param restHost the restHost to set
     */
    public void setRestHost(String restHost) {
        this.restHost = restHost;
    }

}

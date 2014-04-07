package org.bioontology.ontologies.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.http.Parser;
import org.bioontology.ontologies.api.http.Requester;

/**
 *
 * @author palexand
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Model {

    protected String id;
    protected Map<?, ?> links;
    protected Map<?, ?> context;

    public <T extends Model> List<T> followLink(String link, Class<T> model, HTTPOptions httpOpts) {
        URI linkURI = URI.create((String) links.get(link));
        Requester req = new Requester(httpOpts);
        return Parser.parseGeneric(req.get(linkURI), model);
    }

    /**
     * @return the id
     */
    @JsonProperty("@id")
    public String getId() {
        return id;
    }

    /**
     * @return the links
     */
    public Map<?, ?> getLinks() {
        return links;
    }

    /**
     * @return the context
     */
    @JsonProperty("@context")
    public Map<?, ?> getContext() {
        return context;
    }

}

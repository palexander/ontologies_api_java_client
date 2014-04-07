package org.bioontology.ontologies.api.models;

import java.net.URI;
import java.util.List;
import org.bioontology.ontologies.api.annotations.RESTHints;
import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.http.Parser;
import org.bioontology.ontologies.api.http.Requester;

/**
 *
 * @author palexand
 */
@RESTHints(
        mediaType = "http://data.bioontology.org/metadata/Ontology"
)
public class NCBOOntology extends Model {

    private static final String MEDIA_TYPE = "http://data.bioontology.org/metadata/Ontology";

    private String acronym;
    private String name;
    private List<String> administeredBy;
    private List<String> group;
    private String viewingRestriction;
    private Boolean flat;
    private List<String> hasDomain;
    private Boolean summaryOnly;
    private List<String> acl;
    private String viewOf;
    private List<String> views;

    public List<NCBOSubmission> getSubmissions(HTTPOptions httpOpts) {
        URI linkURI = URI.create((String) links.get("submissions"));
        Requester req = new Requester(httpOpts);
        return Parser.parseList(req.get(linkURI), NCBOSubmission.class);
    }

    /**
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the administeredBy
     */
    public List<String> getAdministeredBy() {
        return administeredBy;
    }

    /**
     * @return the group
     */
    public List<String> getGroup() {
        return group;
    }

    /**
     * @return the viewingRestriction
     */
    public String getViewingRestriction() {
        return viewingRestriction;
    }

    /**
     * @return the flat
     */
    public Boolean getFlat() {
        return flat;
    }

    /**
     * @return the hasDomain
     */
    public List<String> getHasDomain() {
        return hasDomain;
    }

    /**
     * @return the summaryOnly
     */
    public Boolean getSummaryOnly() {
        return summaryOnly;
    }

    /**
     * @return the acl
     */
    public List<String> getAcl() {
        return acl;
    }

    /**
     * @return the viewOf
     */
    public String getViewOf() {
        return viewOf;
    }

    /**
     * @return the views
     */
    public List<String> getViews() {
        return views;
    }

    public String getMediaType() {
        return MEDIA_TYPE;
    }
}

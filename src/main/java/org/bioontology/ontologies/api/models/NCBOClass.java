package org.bioontology.ontologies.api.models;

import java.util.List;
import org.bioontology.ontologies.api.annotations.RESTHints;

/**
 *
 * @author palexand
 */
@RESTHints(
        mediaType = "http://www.w3.org/2002/07/owl#Class"
)
public class NCBOClass extends Model {

    private String prefLabel;
    private List<String> synonym;
    private List<String> definition;
    private String obsolete;

    /**
     * @return the prefLabel
     */
    public String getPrefLabel() {
        return prefLabel;
    }

    /**
     * @param prefLabel the prefLabel to set
     */
    public void setPrefLabel(String prefLabel) {
        this.prefLabel = prefLabel;
    }

    /**
     * @return the synonym
     */
    public List<String> getSynonym() {
        return synonym;
    }

    /**
     * @param synonym the synonym to set
     */
    public void setSynonym(List<String> synonym) {
        this.synonym = synonym;
    }

    /**
     * @return the definition
     */
    public List<String> getDefinition() {
        return definition;
    }

    /**
     * @param definition the definition to set
     */
    public void setDefinition(List<String> definition) {
        this.definition = definition;
    }

    /**
     * @return the obsolete
     */
    public String getObsolete() {
        return obsolete;
    }

    /**
     * @param obsolete the obsolete to set
     */
    public void setObsolete(String obsolete) {
        this.obsolete = obsolete;
    }

}

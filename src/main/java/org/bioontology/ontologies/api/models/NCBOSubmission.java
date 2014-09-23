package org.bioontology.ontologies.api.models;

import java.util.List;
import org.bioontology.ontologies.api.annotations.RESTHints;

/**
 *
 * @author palexand
 */
@RESTHints(
        mediaType = "http://data.bioontology.org/metadata/OntologySubmission"
)
public class NCBOSubmission extends Model {

    public static class Contact {
    	
    	private String id;
        private String name;
        private String email;

		/**
         * @return the id
         */
        public String getId() {
			return id;
		}

		/**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }
        
        /**
         * @param id the id to set
         */
        public void setId(String id) {
			this.id = id;
		}

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }
    }

    private String hasOntologyLanguage;
    private String homepage;
    private String publication;
    private String uri;
    private String naturalLanguage;
    private String documentation;
    private String version;
    private String creationDate;
    private String description;
    private String status;
    private List<Contact> contact;
    private String released;

    /**
     * @return the hasOntologyLanguage
     */
    public String getHasOntologyLanguage() {
        return hasOntologyLanguage;
    }

    /**
     * @return the homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     * @return the publication
     */
    public String getPublication() {
        return publication;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @return the naturalLanguage
     */
    public String getNaturalLanguage() {
        return naturalLanguage;
    }

    /**
     * @return the documentation
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @return the creationDate
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the contact
     */
    public List<Contact> getContact() {
        return contact;
    }

    /**
     * @return the released
     */
    public String getReleased() {
        return released;
    }

}

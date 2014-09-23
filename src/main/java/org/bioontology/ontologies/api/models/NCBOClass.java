package org.bioontology.ontologies.api.models;

import java.util.List;
import java.util.Map;

import org.bioontology.ontologies.api.annotations.RESTHints;

/**
 * 
 * @author palexand
 */
@RESTHints(mediaType = "http://www.w3.org/2002/07/owl#Class")
public class NCBOClass extends Model {

	private String prefLabel;
	private List<String> synonym;
	private List<String> definition;
	private String notation;
	private List<String> cui;
	private List<String> semanticType;
	private Map<String, List<String>> properties;
	private boolean obsolete;

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
	 * @return the notation
	 */
	public String getNotation() {
		return notation;
	}

	/**
	 * @param notation the notation to set
	 */
	public void setNotation(String notation) {
		this.notation = notation;
	}

	/**
	 * @return the cui
	 */
	public List<String> getCui() {
		return cui;
	}

	/**
	 * @param cui the cui to set
	 */
	public void setCui(List<String> cui) {
		this.cui = cui;
	}

	/**
	 * @return the semanticType
	 */
	public List<String> getSemanticType() {
		return semanticType;
	}

	/**
	 * @param semanticType the semanticType to set
	 */
	public void setSemanticType(List<String> semanticType) {
		this.semanticType = semanticType;
	}

	/**
	 * @return the properties
	 */
	public Map<String, List<String>> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Map<String, List<String>> properties) {
		this.properties = properties;
	}

	/**
	 * @return the obsolete
	 */
	public boolean isObsolete() {
		return obsolete;
	}

	/**
	 * @param obsolete the obsolete to set
	 */
	public void setObsolete(boolean obsolete) {
		this.obsolete = obsolete;
	}

}

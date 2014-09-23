package org.bioontology.ontologies.api.util;

/**
 * 
 * @author palexand
 */
public class SearchOptions {

	public boolean exactMatch;
	public String ontologies;	
	public boolean requireDefinition;
	public boolean includeProperties;
	public boolean includeObsolete;
	public String cui;
	public String semanticTypes;
	// Available attributes to include: prefLabel,synonym,definition,notation,cui,semanticType,properties
	public String include;
	public int pageNum;
	public int pageSize;
	
	public SearchOptions() {
		pageNum = 1;
		pageSize = 50;		
		exactMatch = false;
	}

	public SearchOptions(int pageNum,int pageSize,  
			boolean exactMatch, String ontologies, boolean requireDefinition,
			boolean includeProperties, boolean includeObsolete, String cui,
			String semanticTypes, String include) {		
		this.pageNum = pageNum;
		this.pageSize = pageSize;		
		this.exactMatch = exactMatch;
		this.ontologies = ontologies;		
		this.requireDefinition = requireDefinition;
		this.includeProperties = includeProperties;
		this.includeObsolete = includeObsolete;
		this.cui = cui;
		this.semanticTypes = semanticTypes;
		this.include = include;
	}

	public String toParams(String text) {
		String query = "q=" + text + "&pagesize=" + pageSize + "&page="
				+ pageNum + "&exact_match=" + exactMatch;
		if (ontologies!=null)
			query+="&ontologies="+ontologies;
		if (requireDefinition)
			query+="&require_definition=" + requireDefinition;
		if (includeProperties)
			query+="&include_properties=" + includeProperties;
		if (includeObsolete)
			query+="&include_obsolete=" + includeObsolete;
		if (cui!=null)
			query+="&cui="+cui;
		if (semanticTypes!=null)
			query+="&semantic_types=" + semanticTypes;
		if (include!=null)
			query+="&include=" + include;

		return query;
	}
}
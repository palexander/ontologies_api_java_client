package org.bioontology.ontologies.api.util;

/**
 *
 * @author palexand
 */
public class SearchOptions {

    public boolean exactMatch;
    public int pageSize;
    public int pageNum;

    public SearchOptions() {
        pageSize = 50;
        pageNum = 1;
        exactMatch = false;
    }

    public String toParams(String text) {
        return "q=" + text
                + "&pagesize=" + pageSize
                + "&page=" + pageNum
                + "&exact_match=" + exactMatch;
    }
}

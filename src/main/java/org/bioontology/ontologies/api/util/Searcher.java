package org.bioontology.ontologies.api.util;

import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.http.Parser;
import org.bioontology.ontologies.api.http.Requester;
import org.bioontology.ontologies.api.models.NCBOClass;
import org.bioontology.ontologies.api.pages.NCBOPage;

/**
 *
 * @author palexand
 */
public class Searcher {

    public static NCBOPage search(String text, SearchOptions searchOpts, HTTPOptions httpOpts) {
        Requester req = new Requester(httpOpts);
        String resp = req.get("/search", searchOpts.toParams(text));
        return Parser.parsePage(resp, NCBOClass.class, httpOpts);
    }
}

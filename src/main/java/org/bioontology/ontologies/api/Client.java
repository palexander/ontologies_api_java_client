package org.bioontology.ontologies.api;

import java.net.URI;
import java.util.List;
import org.bioontology.ontologies.api.annotations.RESTHints;
import org.bioontology.ontologies.api.http.Browser;
import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.http.Parser;
import org.bioontology.ontologies.api.http.Requester;
import org.bioontology.ontologies.api.models.Model;
import org.bioontology.ontologies.api.models.NCBOClass;
import org.bioontology.ontologies.api.pages.NCBOPage;
import org.bioontology.ontologies.api.util.SearchOptions;
import org.bioontology.ontologies.api.util.Searcher;

/**
 *
 * @author palexand
 */
public class Client {

    private final HTTPOptions opts;

    public Client(HTTPOptions opts) {
        this.opts = opts;
        if (opts.getApikey() == null || opts.getApikey().equals("")) {
            throw new IllegalArgumentException("You must provide an API Key to use the client");
        }
    }

    public <T extends Model> List<T> getAll(Class<T> model) {
        return getAll(model, opts);
    }

    public <T extends Model> List<T> getAll(Class<T> model, HTTPOptions httpOpts) {
        RESTHints hint = (RESTHints) model.getAnnotation(RESTHints.class);
        String collectionURL = Browser.getCollectionURL(hint.mediaType(), httpOpts);
        Requester req = new Requester(httpOpts);
        URI uri = URI.create(collectionURL);
        return Parser.parseList(req.get(uri), model);
    }

    public <T extends Model> T getByID(String id, Class<T> model) {
        return getByID(id, model, opts);
    }

    public <T extends Model> T getByID(String id, Class<T> model, HTTPOptions httpOpts) {
        Requester req = new Requester(httpOpts);
        URI uri = URI.create(id);
        return Parser.parseModel(req.get(uri), model);
    }

    public NCBOPage<NCBOClass> search(String text, SearchOptions searchOpts) {
        return search(text, searchOpts, opts);
    }

    public NCBOPage<NCBOClass> search(String text, SearchOptions searchOpts, HTTPOptions httpOpts) {
        return Searcher.search(text, searchOpts, httpOpts);
    }

}

package org.bioontology.ontologies.api.pages;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.http.Parser;
import org.bioontology.ontologies.api.http.Requester;
import org.bioontology.ontologies.api.models.Model;

/**
 *
 * @author palexand
 * @param <T>
 */
public class NCBOPage<T extends Model> implements Iterator<NCBOPage> {

    /**
     * @return the opts
     */
    public HTTPOptions getOpts() {
        return opts;
    }

    /**
     * @param opts the opts to set
     */
    public void setOpts(HTTPOptions opts) {
        this.opts = opts;
    }

    private Integer pageNum;
    private Integer totalPages;
    private Integer nextPageNum;
    private Integer prevPageNum;
    private URI nextPageURI;
    private URI prevPageURI;
    private List<Model> collection;
    private HTTPOptions opts;
    private final Class model;

    public <T extends Model> NCBOPage(Integer pageNum, Integer totalPages, Integer nextPageNum,
            Integer prevPageNum, String nextPage, String prevPage,
            List collection, HTTPOptions opts, Class<T> model) {
        this.pageNum = pageNum;
        this.totalPages = totalPages;
        this.nextPageNum = nextPageNum;
        this.prevPageNum = prevPageNum;
        this.nextPageURI = URI.create(nextPage);
        this.prevPageURI = URI.create(prevPage);
        this.collection = collection;
        this.opts = opts;
        this.model = model;
    }

    @Override
    public boolean hasNext() {
        return nextPageNum != 0;
    }

    @Override
    public NCBOPage next() {
        if (hasNext() == false) {
            return null;
        }
        Requester req = new Requester(getOpts());
        return Parser.parsePage(req.get(nextPageURI), model, opts);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Model> toList() {
        return collection;
    }

    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return the totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return the nextPageNum
     */
    public Integer getNextPageNum() {
        return nextPageNum;
    }

    /**
     * @param nextPageNum the nextPageNum to set
     */
    public void setNextPageNum(Integer nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    /**
     * @return the prevPageNum
     */
    public Integer getPrevPageNum() {
        return prevPageNum;
    }

    /**
     * @param prevPageNum the prevPageNum to set
     */
    public void setPrevPageNum(Integer prevPageNum) {
        this.prevPageNum = prevPageNum;
    }

    /**
     * @return the nextPageURI
     */
    public URI getNextPageURI() {
        return nextPageURI;
    }

    /**
     * @param nextPageURI the nextPageURI to set
     */
    public void setNextPageURI(URI nextPageURI) {
        this.nextPageURI = nextPageURI;
    }

    /**
     * @return the prevPageURI
     */
    public URI getPrevPageURI() {
        return prevPageURI;
    }

    /**
     * @param prevPageURI the prevPageURI to set
     */
    public void setPrevPageURI(URI prevPageURI) {
        this.prevPageURI = prevPageURI;
    }

    /**
     * @return the collection
     */
    public List<Model> getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(List<Model> collection) {
        this.collection = collection;
    }

    /**
     * @return the model
     */
    public Class getModel() {
        return model;
    }
}

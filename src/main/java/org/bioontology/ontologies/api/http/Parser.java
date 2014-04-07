package org.bioontology.ontologies.api.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bioontology.ontologies.api.models.Model;
import org.bioontology.ontologies.api.pages.NCBOPage;

/**
 *
 * @author palexand
 */
public class Parser {

    static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode jsonToNode(String json) {
        JsonNode root = null;
        try {
            root = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, e);
        }
        return root;
    }

    public static <T extends Model> List<T> parseGeneric(String json, Class<T> cls) {
        JsonNode obj = jsonToNode(json);
        List parsedObj = new ArrayList<>();
        try {
            if (obj.isArray()) {
                parsedObj = mapper.readValue(obj.traverse(), mapper.getTypeFactory().constructCollectionType(List.class, cls));
            } else {
                parsedObj.add(mapper.readValue(obj.traverse(), cls));
            }
        } catch (IOException e) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, e);
        }
        return parsedObj;
    }

    public static <T extends Model> T parseModel(String json, Class<T> cls) {
        T parsedObject = null;
        try {
            parsedObject = mapper.readValue(json, cls);
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parsedObject;
    }

    public static <T extends Model> List<T> parseList(String json, Class<T> cls) {
        List<T> parsedObject = null;
        try {
            parsedObject = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, cls));
        } catch (IOException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parsedObject;
    }

    public static <T extends Model> NCBOPage parsePage(String json, Class<T> model, HTTPOptions opts) {
        JsonNode node = jsonToNode(json);
        if (!node.hasNonNull("collection")) {
            throw new UnsupportedOperationException("This response isn't a page");
        }
        Integer pageNum = node.get("page").asInt();
        Integer totalPages = node.get("pageCount").asInt();
        Integer nextPageNum = node.get("nextPage").asInt();
        Integer prevPageNum = node.get("prevPage").asInt();
        String nextPageURI = node.get("links").get("nextPage").asText();
        String prevPageURI = node.get("links").get("prevPage").asText();
        List collection = convertCollection(node.get("collection").elements(), model);

        NCBOPage page = new NCBOPage(pageNum, totalPages, nextPageNum, prevPageNum,
                nextPageURI, prevPageURI, collection, opts, model);

        return page;
    }

    private static <T extends Model> List<Model> convertCollection(Iterator<JsonNode> list, Class<T> model) {
        List newList = new ArrayList<>();
        JsonNode node = list.next();
        while (list.hasNext()) {
            try {
                newList.add(mapper.readValue(node.traverse(), model));
                node = list.next();
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newList;
    }

}

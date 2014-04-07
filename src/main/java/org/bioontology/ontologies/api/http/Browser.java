package org.bioontology.ontologies.api.http;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author palexand
 */
public class Browser {

    public static String getCollectionURL(String mediaType, HTTPOptions opts) {
        Requester req = new Requester(opts);
        String resp = req.get("/");
        JsonNode jsonNode = Parser.jsonToNode(resp);
        Iterator<Map.Entry<String, JsonNode>> ji = jsonNode.get("links").get("@context").fields();
        String nodeName = "";
        Map.Entry<String, JsonNode> node = ji.next();
        while (ji.hasNext()) {
            if (node.getValue().asText().equals(mediaType)) {
                nodeName = node.getKey();
            }
            node = ji.next();
        }
        return jsonNode.get("links").get(nodeName).asText();
    }

}

package org.bioontology.ontologies.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bioontology.ontologies.api.http.HTTPOptions;
import org.bioontology.ontologies.api.models.NCBOClass;
import org.bioontology.ontologies.api.models.NCBOOntology;
import org.bioontology.ontologies.api.models.NCBOSubmission;
import org.bioontology.ontologies.api.pages.NCBOPage;
import org.bioontology.ontologies.api.util.SearchOptions;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author palexand
 */
public class ClientTest {

    private String apikey;
    private HTTPOptions opts = null;

    public ClientTest() {
        apikey = null;

        Properties configFile = new Properties();
        try {
            configFile.load(this.getClass().getResourceAsStream("test_config.properties"));
            apikey = configFile.getProperty("APIKEY");
        } catch (IOException ex) {
            Logger.getLogger(ClientTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (apikey == null || apikey.equals("")) {
            throw new IllegalArgumentException("Please provide an API Key in the "
                    + "test_config.properties file (see test_config.properties.sample for syntax)");
        }
    }

    @BeforeClass
    public static void setUpClass() {
        Logger.getGlobal().setLevel(Level.FINER);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class Client.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Client client = new Client(getHTTPOptions());
        List<NCBOOntology> result = client.getAll(NCBOOntology.class);
        assert (result.size() > 350);
    }

    @Test
    public void testGetByID() {
        System.out.println("getByID");
        String id = "http://data.bioontology.org/ontologies/SNOMEDCT";
        Client client = new Client(getHTTPOptions());
        NCBOOntology ont = client.getByID(id, NCBOOntology.class);
        assertEquals(id, ont.getId());
    }

    @Test
    public void testGetSubmissions() {
        System.out.println("getSubmissions");
        String id = "http://data.bioontology.org/ontologies/SNOMEDCT";
        Client client = new Client(getHTTPOptions());
        NCBOOntology ont = client.getByID(id, NCBOOntology.class);
        List<NCBOSubmission> submissions = ont.getSubmissions(getHTTPOptions());
        assert (submissions.size() > 2);
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        Client client = new Client(getHTTPOptions());
        SearchOptions searchOpts = new SearchOptions();
        NCBOPage<NCBOClass> classes = client.search("melanoma", searchOpts);
        assert (classes.getCollection().size() > 10);
    }

    @Test
    public void testSearchIteration() {
        System.out.println("searchIteration");
        Client client = new Client(getHTTPOptions());
        SearchOptions searchOpts = new SearchOptions();
        NCBOPage<NCBOClass> result = client.search("melanoma", searchOpts);
        List<NCBOClass> classes = new ArrayList<>();
        while (result.hasNext()) {
            classes.addAll(result.getCollection());
            result = result.next();
        }
        assert (classes.size() >= 2200);
    }

    @Test
    public void testFollowLink() {
        System.out.println("followLink");
        String id = "http://data.bioontology.org/ontologies/SNOMEDCT";
        Client client = new Client(getHTTPOptions());
        NCBOOntology ont = client.getByID(id, NCBOOntology.class);
        List<NCBOSubmission> submissions = ont.followLink("latest_submission", NCBOSubmission.class, opts);
        assert (submissions.size() == 1);
        assert (submissions.get(0) instanceof NCBOSubmission);
    }

    private HTTPOptions getHTTPOptions() {
        if (opts == null) {
            opts = new HTTPOptions(apikey);
        }
        return opts;
    }
}

# NCBO REST API Client Example

A very basic example of creating a Java client for the NCBO REST API (http://data.bioontology.org/documentation)

Note: This is an UNOFFICIAL client, unsupported by NCBO

## Usage

```java
// API Key is available from http://bioportal.bioontology.org/account
String apikey = "MY APIKEY";
HTTPOptions opts = new HTTPOptions(apikey);
Client client = new Client(getHTTPOptions());

// Get all ontologies
List<NCBOOntology> result = client.getAll(NCBOOntology.class);

// Get a single ontology by ID
String id = "http://data.bioontology.org/ontologies/SNOMEDCT";
NCBOOntology ont = client.getByID(id, NCBOOntology.class);

// Search classes
SearchOptions searchOpts = new SearchOptions();
NCBOPage<NCBOClass> result = client.search("melanoma", searchOpts);

// Follow hypermedia links
NCBOOntology ont = client.getByID(id, NCBOOntology.class);
List submissions = ont.followLink("latest_submission", NCBOSubmission.class, opts);

// Provide parameters when retrieving resources
HTTPParameters params = new HTTPParameters();
params.addParameter("include", "acronym,name,viewOf");
NCBOOntology ont = client.getByID(id, NCBOOntology.class, params);
```

## Contact

Open an issue, pull request, or reach out to me at [@palexander](https://twitter.com/palexander)

## License

Copyright (c) 2014 Paul R Alexander

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

package com.mycompany.app;

import org.jsoup.*;

import java.io.IOException;
import java.nio.file.*;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IOException {

        Path path = Paths.get("../sample.html");
        Document doc = Jsoup.parse(path.toFile(), "UTF-8");
        doc.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Element firstHeading = doc.select("h2").first();
        Element cloned = firstHeading.clone();
        cloned.select("a").first().text("From Java 8");
        firstHeading.after(cloned);
        Files.write(path, doc.html().getBytes());
        assertTrue(false);
        assertTrue(true);
    }
}

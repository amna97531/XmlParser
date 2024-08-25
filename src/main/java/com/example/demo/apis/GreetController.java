package com.example.demo.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetController {
    private static final Map<QName, Class<?>> rootElementMappings = new HashMap<>();

    static {
        // Populate with known root element mappings if any
        // rootElementMappings.put(new QName("namespace", "rootElementName"),
        // YourClass.class);
    }

    @GetMapping(value = "/greet")
    public String greetTheUser() {
        System.out.println("Greet endpoint was called!");
        try {
            // Create a JAXB context for all generated classes
            JAXBContext jaxbContext = JAXBContext.newInstance("teste");

            // Create an Unmarshaller
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Load the XML file
            File xmlFile = new File(
                    "C:\\Users\\amen\\OneDrive\\Documents\\caseStudy\\demo\\src\\main\\resources\\DevOps_GENE_Assessment_Data.xml");

            // Unmarshal the XML file into a JAXBElement
            JAXBElement<?> element = (JAXBElement<?>) unmarshaller.unmarshal(xmlFile);

            // Retrieve the root element name and its content
            QName rootElementName = element.getName();
            Object rootObject = element.getValue();

            // Print root element name
            System.out.println("Root Element Name: " + rootElementName);

            // Handle known root elements
            Class<?> expectedClass = rootElementMappings.get(rootElementName);
            if (expectedClass != null) {
                System.out.println("Parsed Object: " + expectedClass.cast(rootObject));
            } else {
                System.out.println("Unknown root element, handle accordingly.");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return "Hello User";
    }
}

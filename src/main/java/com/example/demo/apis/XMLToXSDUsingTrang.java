package com.example.demo.apis;
import java.io.File;
import java.io.IOException;

public class XMLToXSDUsingTrang {

    public static void convertXMLToXSD(String trangJarPath, String inputXMLPath, String outputXSDPath) throws IOException, InterruptedException {
        // Command to execute Trang jar
        String[] command = {
            "java",
            "-jar", trangJarPath,  // Path to trang.jar
            inputXMLPath,          // Path to input XML file
            outputXSDPath          // Path to output XSD file
        };

        // Execute the command
        ProcessBuilder processBuilder = new ProcessBuilder(command);

        // Set working directory (optional)
        processBuilder.directory(new File(System.getProperty("user.dir")));

        // Start the process
        Process process = processBuilder.start();

        // Wait for the process to finish
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("XSD generated successfully at: " + outputXSDPath);
        } else {
            System.err.println("Error occurred during conversion. Exit code: " + exitCode);
        }
    }

    public static void main(String[] args) {
        // Paths to Trang JAR, input XML, and output XSD
        String trangJarPath = "C:\\Users\\amen\\OneDrive\\Documents\\caseStudy\\demo\\src\\main\\java\\com\\example\\demo\\apis\\trang.jar"; // Update this path
        String inputXMLPath = "C:\\Users\\amen\\OneDrive\\Documents\\caseStudy\\demo\\src\\main\\java\\com\\example\\demo\\apis\\DevOps_GENE_Assessment_Data.xml";
        String outputXSDPath = "C:\\Users\\amen\\OneDrive\\Documents\\caseStudy\\demo\\src\\main\\java\\com\\example\\demo\\apis\\output.xsd"; 

        try {
            convertXMLToXSD(trangJarPath, inputXMLPath, outputXSDPath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

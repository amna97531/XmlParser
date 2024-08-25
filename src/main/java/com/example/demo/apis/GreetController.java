package com.example.demo.apis;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wiztools.xsdgen.XsdGen;



@RestController
public class GreetController {

    @GetMapping(value = "/greet")
        public String greetTheUser(){
        // System.out.println("Greet endpoint was called!");
        try { XsdGen gen = new XsdGen();
            gen.parse(new File("C:\\Users\\amen\\OneDrive\\Documents\\caseStudy\\demo\\src\\main\\java\\com\\example\\demo\\apis\\DevOps_GENE_Assessment_Data.xml"));
            File out = new File("out.xsd");
            gen.write(new FileOutputStream(out));
            
        } catch (Exception e) {
        }
       
        return "Hello User";
    }
}

package de.sigmalab.siggi.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.sigmalab.siggi.example.service.EnvPropertyPrinter;

/**
 * @author  jbellmann
 */
@RestController
public class PrintController {

    private final EnvPropertyPrinter printer;

    @Autowired
    public PrintController(final EnvPropertyPrinter printer) {
        this.printer = printer;
    }

    @RequestMapping(value = "/print")
    public ResponseEntity<String> print() {
        printer.print();
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}

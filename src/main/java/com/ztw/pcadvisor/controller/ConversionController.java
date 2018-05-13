package com.ztw.pcadvisor.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ztw.pcadvisor.model.EuroBaseConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

@RestController
public class ConversionController {

    @RequestMapping("/api/currency")
    public String getCurrency() throws IOException {
        return fetchConverted().getRates().getPln()+" zł";

    }

    private EuroBaseConversion fetchConverted() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EuroBaseConversion euroBaseConversion = objectMapper.readValue(
                new URL("http://data.fixer.io/api/latest?access_key=e60efcada05f873be404d3250b20019e&symbols=PLN,USD"),
                EuroBaseConversion.class);
        return euroBaseConversion;
    }

}

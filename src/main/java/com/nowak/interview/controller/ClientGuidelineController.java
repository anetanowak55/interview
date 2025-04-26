package com.nowak.interview.controller;

import com.nowak.interview.model.ClientGuideline;
import com.nowak.interview.service.ClientGuidelineService;
import com.nowak.interview.service.WordCounterService;
import jakarta.ws.rs.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientGuidelineController {
    ClientGuidelineService clientGuidelineService;
    WordCounterService wordCounterService;

    public ClientGuidelineController(ClientGuidelineService clientGuidelineService, WordCounterService wordCounterService) {
        this.clientGuidelineService = clientGuidelineService;
        this.wordCounterService = wordCounterService;
    }

    @GetMapping("guideline/{serviceId}/{customerId}")
    public ResponseEntity<Object> getGuidelinesForServiceAndClient(@PathParam("serviceId") Integer serviceId, @PathParam("customerId") Integer customerId) {
        List<ClientGuideline> guidelineList = clientGuidelineService.getGuidelinesForServiceAndClient(serviceId, customerId);
        return new ResponseEntity<>(guidelineList, HttpStatus.OK);
    }

    @PostMapping("file/statistics/{countCapital}")
    @Consumes(MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Object> getFileStatistics(@RequestBody String fileContent, @PathParam("countCapital") Boolean countCapital) {
        int wordCount = wordCounterService.countWords(fileContent, countCapital);
        return new ResponseEntity<>(wordCount, HttpStatus.OK);
    }
}

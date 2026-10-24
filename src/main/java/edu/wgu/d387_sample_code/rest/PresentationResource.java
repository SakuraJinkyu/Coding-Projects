package edu.wgu.d387_sample_code.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ResourceConstants.PRESENTATION_V1)
@CrossOrigin
public class PresentationResource {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getPresentation() {

        List<String> presentationTimes = new ArrayList<>();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        ZonedDateTime etTime = ZonedDateTime.of(2026, 6, 1, 9, 0, 0, 0, ZoneId.of("America/New_York"));
        String etFormatted = etTime.format(timeFormatter) + " ET";

        ZonedDateTime mtTime = etTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        String mtFormatted = mtTime.format(timeFormatter) + " MT";

        ZonedDateTime utcTime = etTime.withZoneSameInstant(ZoneId.of("UTC"));
        String utcFormatted = utcTime.format(timeFormatter) + " UTC";

        presentationTimes.add(etFormatted);
        presentationTimes.add(mtFormatted);
        presentationTimes.add(utcFormatted);
        return new ResponseEntity<>(presentationTimes, HttpStatus.OK);

    }
}

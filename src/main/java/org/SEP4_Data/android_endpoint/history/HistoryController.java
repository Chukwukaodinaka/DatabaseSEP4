package org.SEP4_Data.android_endpoint.history;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HistoryController
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @NonNull
    private MeasurementService service;

    @GetMapping("/tempHistory")
    public List<Double> getTempHistory(@RequestParam String location, String from, String to)
    {

        LocalDate dateTimefrom = LocalDate.parse(from, formatter);
        LocalDate dateTimeto = LocalDate.parse(to, formatter);
        return service.getTempHistory(location, dateTimefrom, dateTimeto);
    }

    @GetMapping("/humidityHistory")
    public List<Double> gethumHistory(@RequestParam String location, String from, String to)
    {

        LocalDate dateTimefrom = LocalDate.parse(from, formatter);
        LocalDate dateTimeto = LocalDate.parse(to, formatter);

        return service.getHumidityHistory(location, dateTimefrom, dateTimeto);
    }

    @GetMapping("/lightHistory")
    public List<Boolean> getLightHistory(@RequestParam String location, String from, String to)
    {
        LocalDate dateTimefrom = LocalDate.parse(from, formatter);
        LocalDate dateTimeto = LocalDate.parse(to, formatter);
        return service.getLightHistory(location, dateTimefrom, dateTimeto);
    }

    @GetMapping("/co2History")
    public List<Float> getco2History(@RequestParam String location, String from, String to)
    {

        LocalDate dateTimefrom = LocalDate.parse(from, formatter);
        LocalDate dateTimeto = LocalDate.parse(to, formatter);
        return service.getCo2History(location, dateTimefrom, dateTimeto);
    }


}

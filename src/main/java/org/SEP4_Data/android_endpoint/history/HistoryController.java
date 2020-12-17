package org.SEP4_Data.android_endpoint.history;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.MeasurementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HistoryController {

    @NonNull
    private MeasurementService service;


    @GetMapping("/tempHistory")
    public List<Double> getTempHistory(@RequestParam HistoryDTO historyDTO )
    {
       return  service.getTempHistory(historyDTO.location,historyDTO.from,historyDTO.to);
    }

    @GetMapping("/humidityHistory")
    public List<Double> gethumHistory(@RequestParam HistoryDTO historyDTO )
    {
        return  service.getHumidityHistory(historyDTO.location,historyDTO.from,historyDTO.to);
    }

    @GetMapping("/lightHistory")
    public List<Boolean> getLightHistory(@RequestParam HistoryDTO historyDTO )
    {
        return  service.getLightHistory(historyDTO.location,historyDTO.from,historyDTO.to);
    }

    @GetMapping("/co2History")
    public List<Float> getco2History(@RequestParam HistoryDTO historyDTO )
    {
        return  service.getCo2History(historyDTO.location,historyDTO.from,historyDTO.to);
    }



}

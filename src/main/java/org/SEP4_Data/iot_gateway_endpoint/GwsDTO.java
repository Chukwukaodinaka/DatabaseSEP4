package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Getter
@ToString
@Setter
public class GwsDTO {
    private Long rssi;
    private Long snr;
    private String time;
}

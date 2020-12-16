package org.SEP4_Data.iot_gateway_endpoint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@Getter
@ToString
@Setter
public class PayLoadDTO {
    private String cmd;
    private Long seqno;
    private String EUI;
    private Long ts;
    private Long fcnt;
    private Long port;
    private Long freq;
    private Long toa;
    private String dr;
    private Boolean ack;

    private Boolean offline;
    private GwsDTO gws;
    private Long bat;
    private String data;
}

//{​​"cmd":"rx","seqno":1102,"EUI":"0004A30B00259D2C","ts":1608138185016,"fcnt":0,"port":1,"freq":867100000,"rssi":-111,"snr":1,"toa":0,"dr":"SF12 BW125 4/5","ack":false,"bat":255,"offline":false,"data":"00000000000000000000000000000000"}​​
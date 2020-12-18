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
    private GwsDTO[] gws;

    private Boolean offline;
    private Long bat;
    private String data;
}


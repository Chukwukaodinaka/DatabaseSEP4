package org.SEP4_Data.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class PayLoad {
    @Id
    @GeneratedValue
    private Long id;
    private String EUI;
    private Boolean ack;
    private Long bat;
    private String cmd;
    private String data;
    private String dr;
    private Long fcnt;
    private Long freq;
    private Boolean offline;
    private Long port;
    private Long rssi;
    private Long seqno;
    private Long snr;
    private Long toa;
    private Long ts;
}

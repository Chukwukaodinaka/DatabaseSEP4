package org.SEP4_Data.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class PayLoad {
    @Id
    @GeneratedValue
    private Long id;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    @NonNull private Device devide_id;
    private Boolean ack;
    private Long bat;
    private String cmd;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    @NonNull private org.SEP4_Data.service.model.Data data_ID;
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
    private LocalDateTime dateTime;
}

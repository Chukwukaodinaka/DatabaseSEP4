package org.SEP4_Data.service.model.source;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.model.source.Device;
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
    @ManyToOne
    @NonNull private Device devide_id;
    private Boolean ack;
    private Long bat;
    private String cmd;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne
    private org.SEP4_Data.service.model.source.Data data_ID;
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

package org.SEP4_Data.service.model.source;

import lombok.*;

import javax.persistence.*;

@Getter
@lombok.Data
@Entity
@RequiredArgsConstructor
public class Data {
    @Id
    @GeneratedValue
    private Long id;

    private double temperature;

    private double humidity;

    private int co2;

    private boolean light;
}

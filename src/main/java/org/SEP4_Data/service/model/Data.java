package org.SEP4_Data.service.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@lombok.Data
@Entity
@RequiredArgsConstructor
public class Data {
    @Id
    @GeneratedValue
    private Long id;

    private int temperature;

    private int humidity;

    private int co2;

    private boolean light;
}

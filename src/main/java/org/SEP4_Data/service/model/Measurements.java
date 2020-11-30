package org.SEP4_Data.service.model;

import lombok.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor

public class Measurements {
    @Id
    @GeneratedValue
    private Long id;

    private int temperature;

    private int humidity;

    private int co2;

    private boolean light;

    private LocalDateTime dateTime;

    @ManyToOne
    @NonNull private Device device;
}

package org.SEP4_Data.service.model;

import lombok.*;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    private String eui;

    @NonNull private String name;

    @NonNull private String location;
}
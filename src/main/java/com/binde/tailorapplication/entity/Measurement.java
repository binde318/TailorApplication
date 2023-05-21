package com.binde.tailorapplication.entity;

import com.binde.tailorapplication.enums.MeasurementType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Measurement extends BaseEntity{
    @Column(name = "measurements")
    @Enumerated(EnumType.STRING)
    private MeasurementType measurementType;


    private double value;



}


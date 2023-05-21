package com.binde.tailorapplication.dto.request;

import com.binde.tailorapplication.enums.MeasurementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementDto {
    private MeasurementType type;

    private double value;
}

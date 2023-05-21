package com.binde.tailorapplication.repository;

import com.binde.tailorapplication.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}

package com.binde.tailorapplication.dto.response;

import com.binde.tailorapplication.dto.request.MeasurementDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private String id;
    private String customerEmail;
    private CustomerResponseDTO customer;
    private String materialType;
    private List<MeasurementDto> measurementList;
    private String duration;
    private  String designImageUrl;
    private  Double orderPrice;
    private LocalDateTime dueDate;
    private String orderStatus;
}


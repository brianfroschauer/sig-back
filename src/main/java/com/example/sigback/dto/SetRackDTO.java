package com.example.sigback.dto;

import com.example.sigback.entity.OrderItem;
import com.example.sigback.entity.RackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetRackDTO {

    private OrderItem orderItem;
    private RackType type;
}

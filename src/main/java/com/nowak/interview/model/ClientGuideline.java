package com.nowak.interview.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter @Getter
public class ClientGuideline {
    @Id
    Integer id;
    @Column(name = "service_id")
    Integer serviceId;
    @Column(name = "customer_id")
    Integer customerId;
    String guideline;
}

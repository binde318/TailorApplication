package com.binde.tailorapplication.entity;

import com.binde.tailorapplication.enums.TokenStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "token_tb")
@Getter
@Setter
public class TokenForPassword extends BaseEntity{
    @Column(length = 500)
    private String token;

    //@Enumerated(EnumType.STRING)
    private TokenStatus tokenStatus;

    @OneToOne()
    @JoinColumn(name = "designer_tb")
    private Designer designer;
}


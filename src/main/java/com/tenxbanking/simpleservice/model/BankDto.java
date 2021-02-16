package com.tenxbanking.simpleservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class BankDto {

    //we can use this to set the json property that we want to see, this will not override
    //we can also use the property naming strategy in the application.properties
    @JsonProperty("bankId")  //we don't have to use this
    @Null
    private String id;

    private UUID uuid;

    @NotBlank
    private String name;

    @Positive
    private Long facNum;

    @JsonFormat(shape = JsonFormat.Shape.STRING) //treat this as a string when serializing
    private BigInteger money;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @JsonSerialize(using = LocalDateSerializer.class) //we can use either the custom serializer method or the shape
    private LocalDate localDate; //we will setup a custom serializer to format the local date
}

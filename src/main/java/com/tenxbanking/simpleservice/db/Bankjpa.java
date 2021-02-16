package com.tenxbanking.simpleservice.db;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.*;

//set up hibernate components
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bankjpa {

    @Id
    @Column(length = 40, columnDefinition = "BIGINT", updatable = false, nullable = false)
    @GeneratedValue(generator = "SEQUENCE")
    @GenericGenerator(name="SEQUENCE", strategy = "org.hibernate.id.SequenceGenerator")
    private Long id;
    @Version
    private Long version;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp dateFormed;
    private BigDecimal worth;
    private Integer numOfClients;
    @Column(unique=true)
    private Long fcaNumber;
}

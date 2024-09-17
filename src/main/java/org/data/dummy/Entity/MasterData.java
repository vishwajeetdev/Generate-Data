/*
package org.data.dummy.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterData {

    @Id
    private String masterId;

    private String firstName;


    private String lastName;


    private BigInteger rollNumber;


    private String laptop;


    private String mobileBrand;


    private String country;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private HealthData healthData;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private MarksData marksData;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private PersonalData personalData;

}
*/

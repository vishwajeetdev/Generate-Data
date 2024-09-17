package org.data.dummy.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@Entity(name = "CLIENT_INFORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {

    @Id
    private String personal_Id;

    String first_name;

    String last_name;

    private String email;

    private BigInteger phone;

    private String date_Of_Birth;

    private String father_First_Name;

    private String father_Last_Name;

    private BigInteger aadhar_Number;

    private BigInteger vid;

    private String country_Name;

    private String pan_Number;

    private String gender;

    private String mother_First_Name;

    private String mother_Last_Name;


}

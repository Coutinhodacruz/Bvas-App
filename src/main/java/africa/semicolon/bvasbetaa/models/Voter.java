package africa.semicolon.bvasbetaa.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voter {

    private Gender gender;
    private String id;
    private UserInformation userInformation;
    private String voterIdentificationNumber;
    private String name;
    private  Address address;
    private Integer age;
}

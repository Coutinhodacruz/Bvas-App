package africa.semicolon.bvasbetaa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Voter {

    private Gender gender;
    private String id;
    private UserInformation userInformation;
    private String voterIndentificationNumber;
    private String name;
    private  Address address;
    private Integer age;
}

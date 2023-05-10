package africa.semicolon.bvasbetaa.models;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

    private String id;

    private UserInformation userInformation;
}

package africa.semicolon.bvasbetaa.utils;

import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int currentId;

    private final static Map<String, String> userInformationJoinTable = new HashMap<>();


    public static String generateId(){
        currentId += 1;
        int generateID = currentId;

        return String.valueOf(generateID);
    }

    public static void linkUserToUserInformation(String userId, String userInformation){
        userInformationJoinTable.put(userId, userInformation);
    }

    public static String  getUserUserInformation(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        return userInformationId;
    }
}


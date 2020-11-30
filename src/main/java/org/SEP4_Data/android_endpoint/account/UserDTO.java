package org.SEP4_Data.android_endpoint.account;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {
    @NonNull
    private String username;

    @NonNull private String password;
}

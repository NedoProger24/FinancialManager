package org.origami.fm.util;

import org.origami.fm.entity.FMUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CheckValidationUtils {
    public static boolean checkUsername(String username) {
        return username == null || username.trim().isEmpty();
    }

    public static boolean notNull(Object o) {
        return o != null;
    }
}

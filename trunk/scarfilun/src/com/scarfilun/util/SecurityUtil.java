package com.scarfilun.util;

import java.security.AccessController;
import java.security.Permission;

import javax.security.auth.Subject;

public class SecurityUtil {

    public static boolean hasPermissions(Permission... permissions){
        for (Permission permission : permissions) {
            try {
                AccessController.checkPermission(permission);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasPermission(Permission permission){               
        try {
            AccessController.checkPermission(permission);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hasAtLeastOnePermission(Permission... permissions){
        for(Permission permission:permissions){
            if(hasPermission(permission)){
                return true;
            }
        }
        return false;
    }

    public static Subject getSubject(){
    	return Subject.getSubject(AccessController.getContext());
    }
}

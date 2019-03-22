package com.company.manerger.sys.service.security.shiro.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroExt {
    /**
     * The guest tag
     *
     * @return
     */
    public boolean isGuest() {
        return getSubject() == null || getSubject().getPrincipal() == null;
    }

    /**
     * The user tag
     *
     * @return
     */
    public boolean isUser() {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }

    /**
     * The authenticated tag
     *
     * @return
     */
    public boolean isAuthenticated() {
        return getSubject() != null && getSubject().isAuthenticated();
    }

    public boolean isNotAuthenticated() {
        return !isAuthenticated();
    }

    /**
     * The principal tag
     *
     * @param map
     * @return
     */
    public String principal(Map map) {
        String strValue = null;
        if (getSubject() != null) {

            // Get the principal to print out
            Object principal;
            String type = map != null ? (String) map.get("type") : null;
            if (type == null) {
                principal = getSubject().getPrincipal();
            } else {
                principal = getPrincipalFromClassName(type);
            }
            String property = map != null ? (String) map.get("property") : null;
            // Get the string value of the principal
            if (principal != null) {
                if (property == null) {
                    strValue = principal.toString();
                } else {
                    strValue = getPrincipalProperty(principal, property);
                }
            }

        }

        if (strValue != null) {
            return strValue;
        } else {
            return null;
        }
    }

    /**
     * The hasRole tag
     *
     * @param roleName
     * @return
     */
    public boolean hasRole(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
    }

    /**
     * The lacksRole tag
     *
     * @param roleName
     * @return
     */
    public boolean lacksRole(String roleName) {
        boolean hasRole = getSubject() != null
                && getSubject().hasRole(roleName);
        return !hasRole;
    }

    /**
     * The hasAnyRole tag
     *
     * @param roleNames
     * @return
     */
    public boolean hasAnyRole(String roleNames) {
        boolean hasAnyRole = false;

        Subject subject = getSubject();

        if (subject != null) {

            // Iterate through roles and check to see if the user has one of the
            // roles
            for (String role : roleNames.split(",")) {

                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }

            }

        }

        return hasAnyRole;
    }

    /**
     * The hasPermission tag
     *
     * @param p
     * @return
     */
    public boolean hasPermission(String p) {
        return getSubject() != null && getSubject().isPermitted(p);
    }

    /**
     * The lacksPermission tag
     *
     * @param p
     * @return
     */
    public boolean lacksPermission(String p) {
        return !hasPermission(p);
    }

    @SuppressWarnings({ "unchecked" })
    private Object getPrincipalFromClassName(String type) {
        Object principal = null;

        try {
            Class cls = Class.forName(type);
            principal = getSubject().getPrincipals().oneByType(cls);
        } catch (ClassNotFoundException e) {

        }
        return principal;
    }

    private String getPrincipalProperty(Object principal, String property) {
        String strValue = null;

        try {
            BeanInfo bi = Introspector.getBeanInfo(principal.getClass());

            // Loop through the properties to get the string value of the
            // specified property
            boolean foundProperty = false;
            for (PropertyDescriptor pd : bi.getPropertyDescriptors()) {
                if (pd.getName().equals(property)) {
                    Object value = pd.getReadMethod().invoke(principal,
                            (Object[]) null);
                    strValue = String.valueOf(value);
                    foundProperty = true;
                    break;
                }
            }

            if (!foundProperty) {
                final String message = "Property [" + property
                        + "] not found in principal of type ["
                        + principal.getClass().getName() + "]";

                throw new RuntimeException(message);
            }

        } catch (Exception e) {
            final String message = "Error reading property [" + property
                    + "] from principal of type ["
                    + principal.getClass().getName() + "]";

            throw new RuntimeException(message, e);
        }

        return strValue;
    }

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }

}

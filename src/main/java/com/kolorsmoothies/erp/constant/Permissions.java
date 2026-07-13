package com.kolorsmoothies.erp.constant;

public final class Permissions {

    private Permissions() {}

    public static final String ADMIN =
            "hasRole('ADMIN')";

    public static final String STORE =
            "hasRole('STORE_MANAGER')";

    public static final String INVENTORY =
            "hasRole('INVENTORY_MANAGER')";

    public static final String SALES =
            "hasRole('SALES_EXECUTIVE')";

    public static final String ADMIN_STORE =
            "hasAnyRole('ADMIN','STORE_MANAGER')";

    public static final String ADMIN_INVENTORY =
            "hasAnyRole('ADMIN','INVENTORY_MANAGER')";

    public static final String ADMIN_SALES =
            "hasAnyRole('ADMIN','SALES_EXECUTIVE')";

    public static final String ALL =
            "hasAnyRole('ADMIN','STORE_MANAGER','INVENTORY_MANAGER','SALES_EXECUTIVE')";
}
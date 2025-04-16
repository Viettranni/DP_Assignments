package com.viettran;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> accessList = new HashSet<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, int documentId) {
        accessList.add(username + ":" + documentId);
    }

    public boolean isAllowed(String username, int documentId) {
        return accessList.contains(username + ":" + documentId);
    }
}

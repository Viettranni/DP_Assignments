package com.viettran;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(int id, String content) {
        documents.put(id, new Document(id, content));
    }

    public void addProtectedDocument(int id, String content, String[] allowedUsers) {
        Document realDoc = new Document(id, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);

        AccessControlService accessService = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            accessService.allowAccess(user, id);
        }
    }

    public DocumentInterface getDocument(int id) {
        return documents.get(id);
    }
}

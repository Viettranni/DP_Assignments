package com.viettran;

import java.time.LocalDate;

public class DocumentProxy implements DocumentInterface {
    private final Document realDocument;
    private final AccessControlService accessService;

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
        this.accessService = AccessControlService.getInstance();
    }

    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessService.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}

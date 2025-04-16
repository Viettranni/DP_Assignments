package com.viettran;

import java.time.LocalDate;

public interface DocumentInterface {
    LocalDate getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}



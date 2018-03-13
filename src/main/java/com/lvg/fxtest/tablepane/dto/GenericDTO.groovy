package com.lvg.fxtest.tablepane.dto

import java.time.LocalDate

abstract class GenericDTO {
    protected static final Long NULL_ID = 0l;
    protected static final String NULL_TEXT_FIELD = "none";
    protected static final LocalDate NULL_DATE_FIELD = LocalDate.of(2000, 1, 1);
}

package com.lvg.fxtest.tablepane.dto

import org.apache.log4j.Logger

import java.time.LocalDate

abstract class GenericDTO {
    protected static final Logger LOGGER = Logger.getLogger(GenericDTO.class)
    protected static final Long NULL_ID = 0l;
    protected static final String NULL_TEXT_FIELD = "none";
    protected static final LocalDate NULL_DATE_FIELD = LocalDate.of(2000, 1, 1);
}

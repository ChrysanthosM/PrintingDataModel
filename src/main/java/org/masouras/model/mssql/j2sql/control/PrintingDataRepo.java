package org.masouras.model.mssql.j2sql.control;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingDataRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        INSERT,
        LIST_UNPROCESSED,
        UPDATE_SET_PROCESSED,
        LIST_TO_PRINT,
        UPDATE_SET_PRINTED,
    }
}

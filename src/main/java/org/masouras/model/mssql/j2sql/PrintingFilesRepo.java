package org.masouras.model.mssql.j2sql;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingFilesRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        INSERT,
        FIND_BY_ID,
    }
}

package org.masouras.model.mssql.j2sql;

import org.masouras.base.repo.datasource.RepoBaseMSSQL;

public interface PrintingOptionsRepo extends RepoBaseMSSQL {
    enum NameOfSQL {
        LIST_PRINTING_SETUP,
    }
}

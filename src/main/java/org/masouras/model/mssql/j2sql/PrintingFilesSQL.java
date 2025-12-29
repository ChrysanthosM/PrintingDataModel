package org.masouras.model.mssql.j2sql;

import org.masouras.base.annotation.J2SqlService;
import org.masouras.base.repo.base.AbstractSQL;
import org.masouras.model.mssql.schema.qb.table.PrintingFilesTable;
import org.springframework.beans.factory.annotation.Autowired;

@J2SqlService("mssql")
public class PrintingFilesSQL extends AbstractSQL<PrintingFilesRepo.NameOfSQL, PrintingFilesJ2SQL, PrintingFilesTable> {
    @Autowired
    public PrintingFilesSQL(PrintingFilesJ2SQL j2sql) {
        super(j2sql);
    }
}


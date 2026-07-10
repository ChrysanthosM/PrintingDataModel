package org.masouras.model.maria.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.model.maria.schema.qb.structure.DbField;
import org.masouras.model.maria.schema.qb.structure.DbTable;


@J2SqlTable("maria")
public class PrintingFilesTable extends AbstractTable {
    private PrintingFilesTable() {
        super(DbTable.PRINTING_FILES);
        setDbFs(REC_ID, CONTENT_BINARY);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField CONTENT_BINARY = getPairOfTableField(DbField.CONTENT_BINARY);
}

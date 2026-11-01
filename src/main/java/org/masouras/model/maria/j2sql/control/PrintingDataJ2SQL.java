package org.masouras.model.maria.j2sql.control;

import org.masouras.base.annotation.J2SqlLoader;
import org.masouras.base.annotation.LoadJ2SQL;
import org.masouras.base.datasource.DataSourceType;
import org.masouras.base.repo.base.AbstractJ2;
import org.masouras.model.maria.schema.jpa.control.entity.enums.PrintingStatus;
import org.masouras.model.maria.schema.jpa.control.entity.enums.PrintingWayType;
import org.masouras.model.maria.schema.qb.structure.DbField;
import org.masouras.model.maria.schema.qb.table.ActivityTable;
import org.masouras.model.maria.schema.qb.table.PrintingDataTable;
import org.masouras.model.maria.schema.qb.table.PrintingFilesTable;
import org.springframework.beans.factory.annotation.Autowired;

import static org.masouras.core.J2SQLShared.PFX;

@J2SqlLoader("maria")
public class PrintingDataJ2SQL extends AbstractJ2<PrintingDataRepo.NameOfSQL> implements PrintingDataRepo {
    private final PrintingDataTable printingDataTable;
    private final PrintingFilesTable printingFilesTable;
    private final ActivityTable activityTable;
    @Autowired
    private PrintingDataJ2SQL(PrintingDataTable printingDataTable, PrintingFilesTable printingFilesTable, ActivityTable activityTable) {
        super(NameOfSQL.class, DataSourceType.MARIA);
        this.printingDataTable = printingDataTable;
        this.printingFilesTable = printingFilesTable;
        this.activityTable = activityTable;
    }

    @LoadJ2SQL
    public void loadInsert() {
        addLoader(NameOfSQL.INSERT, newJ2SQL().insertInto(printingDataTable).insertRow());
    }

    @LoadJ2SQL
    public void loadListUnprocessedBatch() {
        addLoader(NameOfSQL.LIST_UNPROCESSED_BATCH, newJ2SQL().from(printingDataTable.as(PFX.T0)).selectAll()
                .innerJoin(printingFilesTable.as(PFX.T1)).on(PFX.t0(printingDataTable.INITIAL_CONTENT_ID).eq(PFX.t1(printingFilesTable.REC_ID))).fromJoinSelectOnly(printingFilesTable.CONTENT_BINARY.as(DbField.INITIAL_CONTENT_BINARY.systemName()))
                .where(printingDataTable.PRINTING_STATUS.eq(PrintingStatus.INSERTED.getCode()))
                .and(printingDataTable.PRINTING_WAY_TYPE.eq(PrintingWayType.BATCH.getCode()))
                .orderBy(printingDataTable.REC_ID));
    }

    @LoadJ2SQL
    public void loadUpdateSetProcessed() {
        addLoader(NameOfSQL.UPDATE_SET_PROCESSED, newJ2SQL().updateInto(printingDataTable)
                .updateFieldSetValue(printingDataTable.PRINTING_STATUS, PrintingStatus.PROCESSED.getCode())
                .where(printingDataTable.REC_ID.eq("?")));
    }

    @LoadJ2SQL
    public void loadListToPrint() {
        addLoader(NameOfSQL.LIST_TO_PRINT, newJ2SQL().from(printingDataTable.as(PFX.T0))
                .select(PFX.t0(printingDataTable.REC_ID, printingDataTable.FINAL_CONTENT_ID))
                .innerJoin(activityTable, PFX.T1).on(PFX.t0(printingDataTable.ACTIVITY_ID).eq(PFX.t1(activityTable.REC_ID))).fromJoinSelectOnly(PFX.t1(activityTable.ACTIVITY_TYPE))
                .where(printingDataTable.PRINTING_STATUS.eq(PrintingStatus.PROCESSED.getCode()))
                .orderBy(printingDataTable.REC_ID));
    }

    @LoadJ2SQL
    public void loadUpdateSetPrintingStatus() {
        addLoader(NameOfSQL.UPDATE_SET_PRINTING_STATUS, newJ2SQL().updateInto(printingDataTable)
                .updateFieldSetValue(printingDataTable.PRINTING_STATUS, "?")
                .where(printingDataTable.REC_ID.in("?")));
    }
}

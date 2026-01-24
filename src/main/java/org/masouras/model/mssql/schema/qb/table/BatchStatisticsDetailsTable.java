package org.masouras.model.mssql.schema.qb.table;

import org.masouras.base.annotation.J2SqlTable;
import org.masouras.core.AbstractTable;
import org.masouras.core.PairOfTableField;
import org.masouras.model.mssql.schema.qb.structure.DbField;
import org.masouras.model.mssql.schema.qb.structure.DbTable;

@J2SqlTable("mssql")
public class BatchStatisticsDetailsTable extends AbstractTable {
    private BatchStatisticsDetailsTable() {
        super(DbTable.BATCH_STATISTICS_DETAILS);
        setDbFs(REC_ID, JOB_EXECUTION_ID, STEP_NAME, EXIT_STATUS, START_TIME, END_TIME, DURATION_MS, READ_COUNT, WRITE_COUNT, COMMIT_COUNT, ROLLBACK_COUNT, SKIP_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, FILTER_COUNT);
    }

    public final PairOfTableField REC_ID = getPairOfTableField(DbField.REC_ID);
    public final PairOfTableField JOB_EXECUTION_ID = getPairOfTableField(DbField.JOB_EXECUTION_ID);
    public final PairOfTableField STEP_NAME = getPairOfTableField(DbField.STEP_NAME);
    public final PairOfTableField EXIT_STATUS = getPairOfTableField(DbField.EXIT_STATUS);
    public final PairOfTableField START_TIME = getPairOfTableField(DbField.START_TIME);
    public final PairOfTableField END_TIME = getPairOfTableField(DbField.END_TIME);
    public final PairOfTableField DURATION_MS = getPairOfTableField(DbField.DURATION_MS);
    public final PairOfTableField READ_COUNT = getPairOfTableField(DbField.READ_COUNT);
    public final PairOfTableField WRITE_COUNT = getPairOfTableField(DbField.WRITE_COUNT);
    public final PairOfTableField COMMIT_COUNT = getPairOfTableField(DbField.COMMIT_COUNT);
    public final PairOfTableField ROLLBACK_COUNT = getPairOfTableField(DbField.ROLLBACK_COUNT);
    public final PairOfTableField SKIP_COUNT = getPairOfTableField(DbField.SKIP_COUNT);
    public final PairOfTableField READ_SKIP_COUNT = getPairOfTableField(DbField.READ_SKIP_COUNT);
    public final PairOfTableField WRITE_SKIP_COUNT = getPairOfTableField(DbField.WRITE_SKIP_COUNT);
    public final PairOfTableField FILTER_COUNT = getPairOfTableField(DbField.FILTER_COUNT);
}

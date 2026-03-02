package org.masouras.model.mssql.j2sql.boundary;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.query.NativeQuery;
import org.masouras.model.mssql.j2sql.control.PrintingDataRepo;
import org.masouras.model.mssql.j2sql.control.PrintingDataSQL;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.LetterToPrintDTO;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper.ListToPrintMapper;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingStatus;
import org.masouras.model.mssql.schema.jpa.control.util.RepositoryUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class PrintingDataSQLRepository {
    private final PrintingDataSQL printingDataSQL;

    @SuppressWarnings("unchecked")
    public List<LetterToPrintDTO> getListToPrintDTOs() {
        List<Map<String, Object>> rows = (List<Map<String, Object>>) printingDataSQL
                .getNativeQuery(PrintingDataRepo.NameOfSQL.LIST_TO_PRINT)
                .unwrap(NativeQuery.class)
                .setTupleTransformer(RepositoryUtils.tupleTransformer())
                .getResultList();
        return ListToPrintMapper.getListToPrintDTOs(rows);
    }

    public int updateSetPrintingStatus(Set<Long> ids, PrintingStatus printingStatus) {
        if (CollectionUtils.isEmpty(ids)) return 0;
        return printingDataSQL
                .getNativeQuery(PrintingDataRepo.NameOfSQL.UPDATE_SET_PRINTING_STATUS)
                .setParameter(1, printingStatus.getCode())
                .setParameter(2, ids)
                .executeUpdate();
    }

}

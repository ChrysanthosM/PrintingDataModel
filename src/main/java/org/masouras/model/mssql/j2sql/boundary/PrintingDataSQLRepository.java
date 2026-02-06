package org.masouras.model.mssql.j2sql.boundary;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.query.NativeQuery;
import org.masouras.model.mssql.j2sql.control.PrintingDataRepo;
import org.masouras.model.mssql.j2sql.control.PrintingDataSQL;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.ListToPrintDTO;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper.ListToPrintMapper;
import org.masouras.model.mssql.schema.jpa.control.util.RepositoryUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PrintingDataSQLRepository {
    private final PrintingDataSQL printingDataSQL;

    @SuppressWarnings("unchecked")
    public List<ListToPrintDTO> getListToPrintDTOs() {
        List<Map<String, Object>> rows = (List<Map<String, Object>>) printingDataSQL
                .getNativeQuery(PrintingDataRepo.NameOfSQL.LIST_TO_PRINT)
                .unwrap(NativeQuery.class)
                .setTupleTransformer(RepositoryUtils.tupleTransformer())
                .getResultList();
        return ListToPrintMapper.getListToPrintDTOs(rows);
    }

    public int updateSetPrinted(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) return 0;
        return printingDataSQL
                .getNativeQuery(PrintingDataRepo.NameOfSQL.UPDATE_SET_PRINTED)
                .setParameter("ids", ids)
                .executeUpdate();
    }
}

package org.masouras.model.mssql.j2sql.boundary;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.masouras.model.mssql.j2sql.control.PrintingOptionsRepo;
import org.masouras.model.mssql.j2sql.control.PrintingOptionsSQL;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper.PrintingLetterSetUpMapper;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.model.mssql.schema.jpa.control.util.RepositoryUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PrintingOptionsSQLRepository {
    private final PrintingOptionsSQL printingOptionsSQL;

    @SuppressWarnings("unchecked")
    public List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjections() {
        List<Map<String, Object>> rows = (List<Map<String, Object>>) printingOptionsSQL
                .getNativeQuery(PrintingOptionsRepo.NameOfSQL.LIST_PRINTING_SETUP)
                .unwrap(NativeQuery.class)
                .setTupleTransformer(RepositoryUtils.tupleTransformer())
                .getResultList();
        return PrintingLetterSetUpMapper.getPrintingLetterSetUpProjectionImplementors(rows);
    }
}

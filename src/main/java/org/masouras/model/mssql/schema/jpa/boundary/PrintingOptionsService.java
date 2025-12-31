package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.masouras.model.mssql.j2sql.PrintingOptionsRepo;
import org.masouras.model.mssql.j2sql.PrintingOptionsSQL;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper.PrintingLetterSetUpMapper;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.model.mssql.schema.jpa.control.util.RepositoryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrintingOptionsService {
    private final PrintingOptionsSQL printingOptionsSQL;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjections() {
        List<Map<String, Object>> rows = (List<Map<String, Object>>) printingOptionsSQL
                .getNativeQuery(PrintingOptionsRepo.NameOfSQL.LIST_PRINTING_SETUP)
                .unwrap(NativeQuery.class)
                .setTupleTransformer(RepositoryUtils.tupleTransformer())
                .getResultList();
        return PrintingLetterSetUpMapper.getPrintingLetterSetUpProjectionImplementors(rows);
    }
}

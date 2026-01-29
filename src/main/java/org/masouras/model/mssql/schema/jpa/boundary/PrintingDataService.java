package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.masouras.model.mssql.j2sql.PrintingDataRepo;
import org.masouras.model.mssql.j2sql.PrintingDataSQL;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.ListToPrintDTO;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper.ListToPrintMapper;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingDataRepository;
import org.masouras.model.mssql.schema.jpa.control.util.RepositoryUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrintingDataService {
    private final PrintingDataRepository printingDataRepository;
    private final PrintingDataSQL printingDataSQL;

    @Transactional
    public PrintingDataEntity save(PrintingDataEntity entity) {
        return printingDataRepository.save(entity);
    }


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<ListToPrintDTO> getListToPrintDTOs() {
        List<Map<String, Object>> rows = (List<Map<String, Object>>) printingDataSQL
                .getNativeQuery(PrintingDataRepo.NameOfSQL.LIST_TO_PRINT)
                .unwrap(NativeQuery.class)
                .setTupleTransformer(RepositoryUtils.tupleTransformer())
                .getResultList();
        return ListToPrintMapper.getListToPrintDTOs(rows);
    }
}

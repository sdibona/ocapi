package org.akaza.openclinica.domain.dao;

import org.akaza.openclinica.domain.datamap.VersioningMap;
import org.springframework.stereotype.Service;

@Service
public class VersioningMapDao extends AbstractDomainDao<VersioningMap> {

    @Override
    Class<VersioningMap> domainClass() {
        // TODO Auto-generated method stub
        return VersioningMap.class;
    }

}

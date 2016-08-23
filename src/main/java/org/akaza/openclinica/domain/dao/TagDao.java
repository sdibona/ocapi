package org.akaza.openclinica.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.akaza.openclinica.domain.datamap.ItemData;
import org.akaza.openclinica.domain.datamap.EventDefinitionCrfItemTag;
import org.akaza.openclinica.domain.datamap.Tag;
import org.springframework.stereotype.Service;

@Service
public class TagDao extends AbstractDomainDao<Tag> {

    @Override
    Class<Tag> domainClass() {
        // TODO Auto-generated method stub
        return Tag.class;
    }

    
}

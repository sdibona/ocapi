package org.akaza.openclinica.domain.dao;

import java.util.ArrayList;
import org.akaza.openclinica.domain.datamap.CrfVersionMedia;
import org.springframework.stereotype.Service;

@Service
public class CrfVersionMediaDao extends AbstractDomainDao<CrfVersionMedia> {

    @Override
    Class<CrfVersionMedia> domainClass() {
        // TODO Auto-generated method stub
        return CrfVersionMedia.class;
    }

    public ArrayList<CrfVersionMedia> findByCrfVersionId(int crf_version_id) {
        String query = "from " + getDomainClassName() + " crf_version_media  where crf_version_media.crfVersion.crfVersionId = :crfversionid ";
        org.hibernate.Query q = getCurrentSession().createQuery(query);
        q.setInteger("crfversionid", crf_version_id);
        return (ArrayList<CrfVersionMedia>) q.list();
    }
}

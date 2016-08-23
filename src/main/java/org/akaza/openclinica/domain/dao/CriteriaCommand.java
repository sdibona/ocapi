package org.akaza.openclinica.domain.dao;

import org.hibernate.Criteria;

public interface CriteriaCommand {

    public Criteria execute(Criteria criteria);

}

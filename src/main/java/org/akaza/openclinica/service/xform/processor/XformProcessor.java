package org.akaza.openclinica.service.xform.processor;

import org.akaza.openclinica.service.xform.XformContainer;

/**
 * Created by stevedibona on 5/31/16.
 */
public interface XformProcessor {
    public void process(XformContainer container) throws Exception;
}


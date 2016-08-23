package org.akaza.openclinica.service.xform;

import org.akaza.openclinica.service.xform.processor.XformProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * Created by stevedibona on 5/31/16.
 */
@Component
public class XformProcessorChain {

    @Autowired
    List<XformProcessor> processors;

    @PostConstruct
    public void init() {
        Collections.sort(processors, AnnotationAwareOrderComparator.INSTANCE);
    }

    public void processXform(XformContainer container) throws Exception {
        for (XformProcessor processor:processors) {
            processor.process(container);
        }
    }

}


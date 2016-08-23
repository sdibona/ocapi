/*
 * OpenClinica is distributed under the
 * GNU Lesser General Public License (GNU LGPL).

 * For details see: http://www.openclinica.org/license
 * copyright 2003-2007 Akaza Research
 */

package org.akaza.openclinica.util;

import org.akaza.openclinica.domain.datamap.CrfBean;
import org.akaza.openclinica.domain.datamap.CrfVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class Utils {

    @Autowired
    private String attachedFileLocation;

    private static Utils ref;

    private Utils() {
    }

    public static Utils getInstance() {
        if (ref == null) {
            ref = new Utils();
        }
        return ref;
    }

    public String getCrfMediaFilePath(CrfBean crf, CrfVersion version) {
        String attachedFilePath = attachedFileLocation + "attached_files" + File.separator + crf.getOcOid() + File.separator + version.getOcOid()
                    + File.separator;
        return attachedFilePath;
    }

}

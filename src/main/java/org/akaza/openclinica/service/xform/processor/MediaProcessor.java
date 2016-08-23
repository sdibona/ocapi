package org.akaza.openclinica.service.xform.processor;

import org.akaza.openclinica.domain.dao.CrfDao;
import org.akaza.openclinica.domain.dao.CrfVersionDao;
import org.akaza.openclinica.domain.datamap.CrfBean;
import org.akaza.openclinica.domain.datamap.CrfVersion;
import org.akaza.openclinica.service.xform.XformContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by stevedibona on 5/31/16.
 */
@Component
public class MediaProcessor implements XformProcessor, Ordered{

    @Autowired
    String attachedFileLocation;

    @Autowired
    CrfDao crfDao;

    @Autowired
    CrfVersionDao crfVersionDao;

    @Override
    public void process(XformContainer container) throws Exception {
        System.out.println("Executing MediaProcessor");

        CrfBean crf = crfDao.findByName(container.getFormName());
        CrfVersion newVersion = crfVersionDao.findByNameCrfId(container.getVersionName(), crf.getCrfId());

        List<MultipartFile> mediaFiles = container.getXformMedia();

        // Create the directory structure for saving the media
        String dir = getCrfMediaFilePath(crf, newVersion);
        if (!new File(dir).exists()) {
            new File(dir).mkdirs();
            System.out.println("Made the directory " + dir);
        }
        // Save any media files
        for (MultipartFile mediaFile : mediaFiles) {
            String fileName = mediaFile.getOriginalFilename();
            // Some browsers IE 6,7 getName returns the whole path
            int startIndex = fileName.lastIndexOf('\\');
            if (startIndex != -1) {
                fileName = fileName.substring(startIndex + 1, fileName.length());
            }
            File uploadedFile = new File(dir + File.separator + fileName);
            mediaFile.transferTo(uploadedFile);

            /*
            InputStream is = null;
            OutputStream os = null;
            try {
                is = mediaFile.getInputStream();
                mediaFile.transferTo(uploadedFile);
                os = new FileOutputStream(dir + File.separator + fileName);
                byte[] mediaBytes = Base64.decodeBase64(IOUtils.toString(is));
                os.write(mediaBytes);

            } catch (Exception e) {
                throw new OpenClinicaSystemException(e.getMessage());
            } finally {
                if (is != null)
                    try {
                        is.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println(ExceptionUtils.getStackTrace(e));
                    }
                if (os != null)
                    try {
                        os.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println(ExceptionUtils.getStackTrace(e));
                    }
            }
            */
        }

    }

    @Override
    public int getOrder() {
        return 2;
    }

    public String getCrfMediaFilePath(CrfBean crf, CrfVersion version) {
        return attachedFileLocation + crf.getOcOid() + File.separator + version.getOcOid() + File.separator;
    }


}

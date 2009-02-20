package org.codehaus.groovy.grails.webdav

import org.apache.commons.io.IOUtils

/**
 * simple test class, acts as a Mock for a non-folderish domain class
 */

class Leaf implements WebdavLeafish {

    def name
    byte[] data

    public int webdavLength() {
        return data?.size()
    }

    public InputStream webdavReadData() {
        IOUtils
    }

    public int webdavWriteData(InputStream is) {
        data = IOUtils.toByteArray(is)
        webdavLength()
    }

    public String webdavName() {
        name
    }
}
package org.codehaus.groovy.grails.webdav

import org.slf4j.LoggerFactory

class HierarchicalTestMapper extends AbstractWebdavMapperService {

    List<WebdavObject> rootWebdavObjects
    def log = LoggerFactory.getLogger(HierarchicalTestMapper.class)

    protected setupWebdavMethods() {
        null
    }

}
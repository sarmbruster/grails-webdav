package org.codehaus.groovy.grails.webdav

import grails.test.GrailsUnitTestCase
import net.sf.webdav.IWebdavStore
import java.security.Principal

class GrailsWebdavStoreTests extends GrailsUnitTestCase {

    void testDelete() {
        def root = new Folder(name:"root", children:[])
        def mapper = new HierarchicalTestMapper(rootWebdavObjects: [root])
        IWebdavStore store = new GrailsWebdavStore(mapper:mapper)

        Transaction transaction = store.begin(new DummyPrincipal())
        store.createFolder(transaction, "/root/folder")
        store.removeObject(transaction, "/root/folder")

        store.createResource(transaction, "/root/object")
        store.removeObject(transaction, "/root/object")
    }
}

private class DummyPrincipal implements Principal {
    String name = "dummy"
}

package org.codehaus.groovy.grails.webdav
/**
 * simple test class, acts as a Mock for a folderish domain class
 */

public class Folder implements WebdavFolderish {

    List children
    def name

    public List webdavChildren() {
        children
    }

    public void webdavCreateFolder(String name) {
        children << new Folder(name:name)
    }

    public void webdavCreateResource(String name) {
        children << new Leaf(name:name)
    }

    public void webdavRemove(String name) {
        def obj = children.find { it.name == name }
        children.remove(obj)
    }

    public String webdavName() {
        name
    }

    Date webdavLastModified() {
        new Date()
    }

    Date webdavCreated() {
        new Date()
    }
}
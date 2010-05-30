import org.codehaus.groovy.grails.webdav.WebdavObject
import org.codehaus.groovy.grails.webdav.WebdavLeafish
import org.codehaus.groovy.grails.webdav.WebdavFolderish
import org.apache.commons.io.IOUtils
import org.codehaus.groovy.grails.webdav.AbstractWebdavMapperService

class WebdavMapper_webdavflatService extends AbstractWebdavMapperService {

    boolean transactional = true

    protected List<WebdavObject> getRootWebdavObjects() {
        Person.findAll().collect {
            ProxyGenerator.instantiateDelegate([WebdavFolderish], it)
        }
    }

    /**
     * implement webdavXXXX methods for domain classes 
     */
    protected setupWebdavMethods() {

        def p = Person.metaClass
        p.webdavName << { name }
        p.webdavChildren << {
            images.collect {
                ProxyGenerator.instantiateDelegate([WebdavLeafish], it)
            }
        }
        p.webdavCreateResource << { String name -> 
            addToImages(name:name).save()
        }
        p.webdavCreateFolder << { throw new UnsupportedOperationException() }
        p.webdavRemove << { String name ->
            def img = images.findByName(name)
            removeFromImages(img)
        }

        def i = Image.metaClass
        i.webdavName << { name }
        i.webdavLength << { data?.size() }
        i.webdavReadData << {
            new ByteArrayInputStream(data) 
        }
        i.webdavWriteData << {InputStream is ->
            data = IOUtils.toByteArray(is)
            return webdavLength()
        }
    }
}

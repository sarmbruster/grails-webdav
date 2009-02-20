/* Copyright 2009-2009 Stefan Armbruster
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import grails.test.*
import org.codehaus.groovy.grails.webdav.WebdavObject
import org.slf4j.LoggerFactory
import org.codehaus.groovy.grails.webdav.WebdavFolderish
import org.codehaus.groovy.grails.webdav.Folder
import org.codehaus.groovy.grails.webdav.WebdavMapper
import org.codehaus.groovy.grails.webdav.Leaf

class AbstractWebdavMapperServiceTests extends grails.test.GrailsUnitTestCase {

    void testEmptyMapper() {
        def mapper = new HierarchicalTestMapper()

        assertNotNull mapper.getWebdavObject(null)
        assertNotNull mapper.getWebdavObject("")
        def obj = mapper.getWebdavObject("/")
        assertTrue obj instanceof WebdavFolderish
        assertEquals AbstractWebdavMapperService.ROOT_NAME, obj.webdavName()
        assertNull obj.webdavChildren()
    }

    void testSimple() {
        def root = new Folder(name:"root")
        def mapper = new HierarchicalTestMapper(rootWebdavObjects: [root])
        assertEquals root, mapper.getWebdavObject("/root")
    }


    void testSubStructure() {
        def leaf = new Leaf(name:"leaf")
        def folder2 = new Folder(name:"folder2", children: [leaf])
        def folder1 = new Folder(name:"folder1", children: [folder2])
        def root = new Folder(name:"root", children:[folder1])

        def mapper = new HierarchicalTestMapper(rootWebdavObjects: [root])

        assertEquals folder1, mapper.getWebdavObject("/root/folder1")
        assertEquals folder2, mapper.getWebdavObject("/root/folder1/folder2")
        assertEquals leaf, mapper.getWebdavObject("/root/folder1/folder2/leaf")
        assertNull mapper.getWebdavObject("/root/folder1/folder2/notexist")
    }
}

class HierarchicalTestMapper extends AbstractWebdavMapperService {

    List<WebdavObject> rootWebdavObjects
    def log = LoggerFactory.getLogger(HierarchicalTestMapper.class)

    protected setupWebdavMethods() {
        null
    }

}
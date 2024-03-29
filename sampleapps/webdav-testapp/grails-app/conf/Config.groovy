log4j = {
    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
	       'org.codehaus.groovy.grails.web.pages', //  GSP
	       'org.codehaus.groovy.grails.web.sitemesh', //  layouts
	       'org.codehaus.groovy.grails."web.mapping.filter', // URL mapping
	       'org.codehaus.groovy.grails."web.mapping', // URL mapping
	       'org.codehaus.groovy.grails.commons', // core / classloading
	       'org.codehaus.groovy.grails.plugins', // plugins
	       'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
	       'org.springframework',
	       'org.hibernate'

    debug   'org.codehaus.groovy.grails.webdav' //,
            //'org.codehaus.groovy.grails.plugins.springsecurity',
            //'org.springframework.security'
    root.level = org.apache.log4j.Level.WARN
}
// The following properties have been added by the Upgrade process...
grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"


grails.webdav = [
        webdavflat: [
                url: '/webdavflat/*'
        ],
        webdavtree: [
                url: '/webdavtree/*'
        ],

]


//log4j.logger.org.springframework.security='off,stdout'

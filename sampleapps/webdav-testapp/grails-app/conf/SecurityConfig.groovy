security {

	// see DefaultSecurityConfig.groovy for all settable/overridable properties

	active = true
	useRequestMapDomainClass = false

    loginUserDomainClass = "User"
	authorityDomainClass = "Role"
	//requestMapClass = "Requestmap"
    defaultRole = "ROLE_WEBDAV"

    // WebDAV needs BASIC auth
    basicProcessingFilter = true

	requestMapString = '''
 		CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON 
		PATTERN_TYPE_APACHE_ANT

		/webdavflat/**=ROLE_WEBDAV
  	'''
}

// Place your Spring DSL code here
beans = {
    authenticationEntryPoint(org.springframework.security.ui.basicauth.BasicProcessingFilterEntryPoint) {
        realmName = 'Grails Realm'
    }

    passwordEncoder(org.springframework.security.providers.encoding.PlaintextPasswordEncoder)

}
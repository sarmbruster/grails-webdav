import grails.util.GrailsUtil

class BootStrap {

    def init = {servletContext ->

        def p = new Person(name:"Sepp").addToImages(readfile('sa400023.jpg')).addToImages(readfile('sa400024.jpg')).save()
        assert p.save()
        p = new Person(name:"Toni").addToImages(readfile('sa400025.jpg')).save()
        assert p.save()
        p = new Person(name:"Franz").addToImages(readfile('sa400026.jpg')).addToImages(readfile('sa400027.jpg')).save()
        assert p.save()



        new Folder(name:"Top1").addToFiles(readfile('sa400023.jpg'))
                .addToFolders( new Folder(name:"Sub1").addToFiles(readfile('sa400024.jpg')))
                .addToFolders( new Folder(name:"Sub2").addToFiles(readfile('sa400025.jpg'))
                    .addToFolders(new Folder(name:"Sub2Sub1").addToFiles(readfile('sa400026.jpg')))
                ).save()                    

        def role = new Role(authority:"ROLE_WEBDAV", description:"WEBDAV users")
        assert role.save()

        def user = new User(username:'webdav', passwd:'webdav', userRealName:'a webdav user',
                enabled:true, email: 'webdav@nodomain.com')
        user.addToAuthorities(role)
        if( !user.save() ) {
            user.errors.each {
                log.error "user error: $it"
            }
            //assert false
        }

        
    }
    def destroy = {
    }

    private readfile(name) {
        [ name: name, data: new File("data/$name").readBytes()]
    }
} 
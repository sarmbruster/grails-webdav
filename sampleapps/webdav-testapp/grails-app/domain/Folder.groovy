class Folder {

    String name
    Folder parent

    static hasMany = [ files: FileObject, folders:Folder]

    static constraints = {
        parent(nullable:true)
    }

    String toString() {
        name
    }

}

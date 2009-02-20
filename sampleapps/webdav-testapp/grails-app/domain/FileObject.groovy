class FileObject {

    byte[] data
    String name

    static belongsTo = [folder:Folder]

    static constraints = {
        data(maxSize:1000000)
    }

    String toString() {
        name
    }

   
}

class Image {
    byte[] data
    String contentType
    String name

    static constraints = {
        data(nullable:true)
        contentType(nullable:true)
    }
}

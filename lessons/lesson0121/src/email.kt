package email

class Message(msg : String) {
    var text: String = msg
        private set(value){
            if (value.isNotEmpty())
                field = value
        }
        get(){
            return field
        }

    private val letter: Char
        get() = text.first()


    //private
    //protected
    //public
    //internal
}
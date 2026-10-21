package KotlinFund_2

interface Logger {

    fun logToLogcat()

    fun logToFile()

    fun logToCloud()
}

abstract class LogcatLogger : Logger {
    override fun logToLogcat() {
       println("printoing to logcat")
    }

    override fun logToFile() {
        println("printoing to file")

    }

    abstract override fun logToCloud()

}

class LogcatHelper2: LogcatLogger(){
    override fun logToCloud() {
        TODO("Not yet implemented")
    }
}

class FileLogger(): Logger{
    override fun logToLogcat() {
        TODO("Not yet implemented")
    }

    override fun logToFile() {
        TODO("Not yet implemented")
    }

    override fun logToCloud() {
        TODO("Not yet implemented")
    }
}

enum class WEEK(){

}

data class USerV3(val firstName: String, val lastName : String){

}




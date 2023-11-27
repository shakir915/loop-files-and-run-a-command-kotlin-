import java.io.File


fun main(args: Array<String>) {

    convertWaveMp3ForIos()


}


fun convertWaveMp3ForIos() {


    travers(File("/Users/shakir/Downloads/masajid_sounds")){
        println("path ${it.path}")
        var command = "afconvert  \"${it.path}\" \"${
            it.path.split(".").toMutableList().apply { removeLast() }.joinToString("")
        }.caf\"     -d ima4 -f caff -v"
        println(command)
        println(" out " + command.runCommand {

        })
    }

     travers(File("/Users/shakir/Downloads/masajid_sounds")){
       if (!it.name.endsWith(".caf")){
           it.delete()
       }
    }





}


fun travers(file: File, function: (File) -> Unit) {
    file.listFiles()?.forEach {
        if (it.isDirectory) {
            travers(it,function)
        } else {
            function.invoke(it)
        }
    }
}

package ahmyouss

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import java.nio.file.Paths

class PsychoGraphyProjectCreator: CliktCommand() {
    private val projectName by argument(name = "projectName")
    private val rootPath by argument(name = "rootPath").file(folderOkay = true, readable = true, writable = true)
    private val newProjectOption by option("-c", "--createNewProject", help = "Create new Project Folders Structure").flag()
    private val timeLapseOption by option("-tl", "--timeLapse", help = "Creates timelapse from your edited pictures using FFMPEG").flag()
    private val scalePicturesOptions by option("-s", "--scalePictures", help = "Creates a scaled version of the RAW  pictures using FFMPEG").flag()


    override fun run() {
        val projectPath = Paths.get(rootPath.path, projectName)

        if (!newProjectOption && !timeLapseOption && !scalePicturesOptions) {
            println("Please use one of the options running this tool!")
            return
        }

        if (newProjectOption) {
            val psychoGraphyProject = PsychoGraphyProject(projectPath)
            "Created new Project Structure at $projectPath"
        }

        if (timeLapseOption) {
            val timeLapser = TimeLapser(projectPath)
        }

        if (scalePicturesOptions) {
            val scaler = PictureScaler(projectPath)
        }

    }



}

fun main(args: Array<String>) {
    PsychoGraphyProjectCreator().main(args)
}

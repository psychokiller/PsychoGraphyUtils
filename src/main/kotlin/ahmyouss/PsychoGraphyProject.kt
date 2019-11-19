package ahmyouss

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class PsychoGraphyProject(projectPath: Path) {

    private val foldersList = listOf(
        projectPath.resolve(Paths.get("RAW")),
        projectPath.resolve(Paths.get("Edited")),
        projectPath.resolve(Paths.get("Videos")),
        projectPath.resolve(Paths.get("LR")),
        projectPath.resolve(Paths.get("TimeLapse")),
        projectPath.resolve(Paths.get("Scaled"))
    )

    init {

        createProjectSubDirectories()
    }

    private fun createProjectSubDirectories() {
        foldersList.filter { !Files.exists(it) }
            .forEach { Files.createDirectories(it) }
    }
}
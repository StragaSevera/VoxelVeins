package ru.ought.voxel_veins

import com.beust.klaxon.Klaxon
import java.io.BufferedWriter
import java.nio.file.*

fun main(args: Array<String>) {
    val worldName = args[0]
    val modsArg = if (args.size == 1) "" else args[1]
    val modsPath = Paths.get(modsArg)
    val journeyPath = modsPath.resolve("waypoints")
    val voxelPath = modsPath.resolve("VoxelMods/voxelMap/$worldName.points")
    val lines = getJourneyLines(journeyPath)
    appendVoxelLines(lines, voxelPath)
}

private fun getJourneyLines(journeyPath: Path): Sequence<VeinLine> {
    val parser = Klaxon()
    val files = journeyPath.toFile().walk().filter { it.isFile }.sortedBy { it.name }
    return files.mapNotNull { parser.parse<JourneyLine>(it) }.map { VeinLine.of(it) }
}

private fun appendVoxelLines(lines: Sequence<VeinLine>, voxelPath: Path) {
    var voxelWriter: BufferedWriter? = null
    try {
        if (Files.notExists(voxelPath)) {
            println("${voxelPath.fileName} does not exist! Creating...")
            voxelWriter = Files.newBufferedWriter(voxelPath, StandardOpenOption.CREATE)
            voxelWriter.write("subworlds: \noldNorthWorlds: ")
        } else {
            println("${voxelPath.fileName} exist. Appending...")
            voxelWriter = Files.newBufferedWriter(voxelPath, StandardOpenOption.APPEND)
        }
        val presentLines = voxelPath.toFile().readLines()
        val uniqueNames = mutableListOf<String>()
        var linesAdded = 0
        for (line in lines) {
            val lineString = line.toString()
            if (lineString !in presentLines) {
                if (line.name !in uniqueNames) {
                    uniqueNames += line.name
                    println("Processing ${line.name}")
                }
                voxelWriter.newLine()
                voxelWriter.write(lineString)
                linesAdded++
            }
        }
        println("Successfully converted! Lines added: $linesAdded")
    } finally {
        voxelWriter?.close()
    }
}
package ru.ought.voxel_veins

import java.util.*

data class VeinLine(
    val name: String,
    val x: Int,
    val y: Int,
    val z: Int,
    val red: Double,
    val green: Double,
    val blue: Double,
    val suffix: String,
    val dimension: Int
) {
    companion object {
        fun of(journeyLine: JourneyLine): VeinLine {
            val journeyName = journeyLine.name
            val veinType = getVeinType(journeyName)
            val nameCompact = if (journeyName.startsWith("Custom")) "Cus${journeyName.last()}"
            else journeyName
            return VeinLine(
                name = nameCompact,
                x = journeyLine.x,
                y = journeyLine.y,
                z = journeyLine.z,
                red = veinType.red,
                green = veinType.green,
                blue = veinType.blue,
                suffix = veinType.suffix,
                dimension = journeyLine.dimensions.first()
            )
        }
    }

    override fun toString(): String {
        val redFormatted = "%f".format(Locale.ENGLISH, red)
        val greenFormatted = "%f".format(Locale.ENGLISH, green)
        val blueFormatted = "%f".format(Locale.ENGLISH, blue)
        return "name:$name,x:$x,z:$z,y:$y,enabled:false," +
                "red:${redFormatted},green:${greenFormatted},blue:${blueFormatted}," +
                "suffix:$suffix,world:,dimensions:$dimension"
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
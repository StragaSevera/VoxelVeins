package ru.ought.voxel_veins

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
        return "name:$name,x:$x,z:$z,y:$y,enabled:false," +
                "red:${red.format(8)},green:${green.format(8)},blue:${blue.format(8)}," +
                "suffix:$suffix,world:,dimensions:$dimension"
    }

    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}
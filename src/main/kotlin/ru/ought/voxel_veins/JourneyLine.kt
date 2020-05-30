package ru.ought.voxel_veins

@Suppress("DuplicatedCode")
data class JourneyLine(
    val id: String, val name: String, val icon: String,
    val x: Int, val y: Int, val z: Int,
    val r: Int, val g: Int, val b: Int,
    val enable: Boolean, val type: String,
    val origin: String, val dimensions: IntArray
) {
    // Overriding because of Array
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JourneyLine

        if (id != other.id) return false
        if (name != other.name) return false
        if (icon != other.icon) return false
        if (x != other.x) return false
        if (y != other.y) return false
        if (z != other.z) return false
        if (r != other.r) return false
        if (g != other.g) return false
        if (b != other.b) return false
        if (enable != other.enable) return false
        if (type != other.type) return false
        if (origin != other.origin) return false
        if (!dimensions.contentEquals(other.dimensions)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + icon.hashCode()
        result = 31 * result + x
        result = 31 * result + y
        result = 31 * result + z
        result = 31 * result + r
        result = 31 * result + g
        result = 31 * result + b
        result = 31 * result + enable.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + dimensions.contentHashCode()
        return result
    }
}
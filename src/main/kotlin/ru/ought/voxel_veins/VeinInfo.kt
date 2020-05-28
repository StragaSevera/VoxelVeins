package ru.ought.voxel_veins

data class VeinInfo(val red: Double, val green: Double, val blue: Double, val suffix: String)

private val VEIN_DATA: Map<String, VeinInfo> = mapOf(
    "Apatite" to VeinInfo(red = 0.79607844, green = 0.73333335, blue = 0.9019608, suffix = "Gear"),
    "Bauxite" to VeinInfo(red = 0.2509804, green = 0.8352941, blue = 0.9411765, suffix = "Gear"),
    "Beryllium" to VeinInfo(red = 0.007843138, green = 0.93333334, blue = 0.15294118, suffix = "Person"),
    "Cassiterite" to VeinInfo(red = 0.5058824, green = 0.5058824, blue = 0.5058824, suffix = "Gear"),
    "Coal" to VeinInfo(red = 0.9843137, green = 0.3529412, blue = 0.03137255, suffix = "Fire"),
    "Copper" to VeinInfo(red = 0.99607843, green = 0.62352943, blue = 0.078431375, suffix = "Gear"),
    "Diamond" to VeinInfo(red = 0.07058824, green = 0.99607843, blue = 0.8745098, suffix = "Diamond"),
    "Galena" to VeinInfo(red = 0.5372549, green = 0.21568628, blue = 0.6117647, suffix = "Gear"),
    "Gold" to VeinInfo(red = 0.99607843, green = 0.9411765, blue = 0.023529412, suffix = "Diamond"),
    "Iron" to VeinInfo(red = 0.93333334, green = 0.07450981, blue = 0.0, suffix = "Gear"),
    "Lapis" to VeinInfo(red = 0.019607844, green = 0.06666667, blue = 0.654902, suffix = "Person"),
    "Lignite" to VeinInfo(red = 0.99607843, green = 0.8039216, blue = 0.1254902, suffix = "Fire"),
    "Magnetite" to VeinInfo(red = 0.015686275, green = 0.015686275, blue = 0.015686275, suffix = "Gear"),
    "Manganese" to VeinInfo(red = 0.8784314, green = 0.42745098, blue = 0.52156866, suffix = "Gear"),
    "Molybdenum" to VeinInfo(red = 0.30588236, green = 0.15686275, blue = 0.0, suffix = "Gear"),
    "Monazite" to VeinInfo(red = 0.003921569, green = 0.24705882, blue = 0.03137255, suffix = "Gear"),
    "Naquadah" to VeinInfo(red = 0.019607844, green = 0.019607844, blue = 0.019607844, suffix = "Diamond"),
    "Netherquartz" to VeinInfo(red = 0.94509804, green = 0.94509804, blue = 0.94509804, suffix = "Diamond"),
    "Nickel" to VeinInfo(red = 0.12156863, green = 0.24705882, blue = 0.972549, suffix = "Gear"),
    "Oilsand" to VeinInfo(red = 0.4862745, green = 0.06666667, blue = 0.49411765, suffix = "Fire"),
    "Olivine" to VeinInfo(red = 0.003921569, green = 0.9529412, blue = 0.023529412, suffix = "Diamond"),
    "Pitchblende" to VeinInfo(red = 0.8235294, green = 0.972549, blue = 0.13333334, suffix = "Science"),
    "Platinum" to VeinInfo(red = 0.95705146, green = 0.8752846, blue = 0.74186975, suffix = "Gear"),
    "Quartz" to VeinInfo(red = 0.73333335, green = 0.73333335, blue = 0.73333335, suffix = "Diamond"),
    "Redstone" to VeinInfo(red = 0.87058824, green = 0.043137256, blue = 0.0, suffix = "Person"),
    "Salts" to VeinInfo(red = 1.0, green = 0.7058824, blue = 0.6, suffix = "Gear"),
    "Sapphire" to VeinInfo(red = 0.10980392, green = 0.18431373, blue = 0.96862745, suffix = "Diamond"),
    "Soapstone" to VeinInfo(red = 0.08235294, green = 0.99607843, blue = 0.18431373, suffix = "Gear"),
    "Sulfur" to VeinInfo(red = 0.99215686, green = 0.9607843, blue = 0.28235295, suffix = "Science"),
    "Tetrahedrite" to VeinInfo(red = 0.99607843, green = 0.45490196, blue = 0.105882354, suffix = "Gear"),
    "Tungstate" to VeinInfo(red = 0.011764706, green = 0.011764706, blue = 0.011764706, suffix = "Science"),
    "Uranium" to VeinInfo(red = 0.03137255, green = 0.8509804, blue = 0.0, suffix = "Science"),
    "Custom.00" to VeinInfo(red = 0.03137255, green = 0.6509804, blue = 0.0, suffix = "Person"),
    "Custom.01" to VeinInfo(red = 0.04137255, green = 0.4509804, blue = 0.0, suffix = "Person"),
    "Custom.02" to VeinInfo(red = 0.03137255, green = 0.2509804, blue = 0.0, suffix = "Person"),
    "Custom.03" to VeinInfo(red = 0.03137255, green = 0.2509804, blue = 0.2, suffix = "Person"),
    "Custom.04" to VeinInfo(red = 0.03137255, green = 0.2509804, blue = 0.4, suffix = "Person")
)

private val VEIN_INFO_DEFAULT = VeinInfo(red=1.0, green=1.0, blue=1.0, suffix="Cloud")

fun getVeinInfo(name: String) = VEIN_DATA.getOrDefault(name, VEIN_INFO_DEFAULT)
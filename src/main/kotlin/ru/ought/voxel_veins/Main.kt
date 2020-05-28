package ru.ought.voxel_veins

import java.nio.file.Paths

fun main(args: Array<String>) {
    val path = if(args.isEmpty()) "" else args.first()
    val pwd = Paths.get(path).toAbsolutePath()
    println(pwd)
}
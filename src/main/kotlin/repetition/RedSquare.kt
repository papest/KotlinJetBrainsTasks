package repetition

import java.awt.Color.RED
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB
import java.io.File
import javax.imageio.ImageIO

const val WIDTH = 500
fun drawSquare(): BufferedImage {
    val bufferedImage = BufferedImage(WIDTH, WIDTH, TYPE_INT_RGB)
    val graphics = bufferedImage.createGraphics()
    graphics.color = RED
    graphics.drawRect(100, 100, 300, 300)
    return bufferedImage
}

fun main() {
    val file = File("red_square.jpg")
    ImageIO.write(drawSquare(), file.extension, file)
}
import gg.essential.elementa.state.BasicState
import java.awt.Color
import java.util.*

object GuiUtils {
    var rainbowColor = BasicState(Color.RED)

    init {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                try {
                    val time = System.currentTimeMillis() / 10000.0  // Continuous time for infinite cycling
                    val hue = (time % 1).toFloat()  // Keep hue within 0.0 to 1.0 range

                    // Saturation and brightness are kept high for vibrant colors
                    val color = Color.getHSBColor(hue, 0.8f, 1.0f)  // Slightly reduce saturation for a softer look
                    rainbowColor.set(color)
                } catch (e: Exception) {
                    e.printStackTrace()
                    rainbowColor.set(Color(255, 0, 0))
                }
            }
        }, 0, 50)
    }
}
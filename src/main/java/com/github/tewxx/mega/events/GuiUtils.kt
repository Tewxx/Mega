import gg.essential.elementa.state.BasicState
import java.awt.Color
import java.util.Timer
import java.util.TimerTask

object GuiUtils {
    var rainbowColor = BasicState(Color.RED)

    init {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                try {
                    val time = System.currentTimeMillis() % 3600 / 10.0  // Adjust rate for smoother transition
                    val hue = (time % 360) / 360.0  // Cycle through hues

                    val color = Color.getHSBColor(hue.toFloat(), 1.0f, 1.0f)
                    rainbowColor.set(color)
                } catch (e: Exception) {
                    e.printStackTrace()
                    rainbowColor.set(Color(255, 0, 0))
                }
            }
        }, 0, 500) // Adjust the period for smoother transition
    }
}
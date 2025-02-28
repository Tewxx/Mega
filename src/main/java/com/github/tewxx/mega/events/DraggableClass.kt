import gg.essential.elementa.UIComponent
import gg.essential.elementa.constraints.PixelConstraint
import kotlin.Pair

object DraggableClass {
    interface IMoveableUIContainer {
        var isDragging: Boolean
        var dragOffset: Pair<Float, Float>
    }

    val onMouseDragHandler: (UIComponent, Float, Float, Int) -> Unit = { component, x, y, mouseButton ->
        val moveableComponent = component as IMoveableUIContainer

        if (!moveableComponent.isDragging || mouseButton != 0) {
            component.onMouseDrag { mouseX, mouseY, mouseButton ->

            }
        }

        val absolutX = x + component.getLeft()
        val absolutY = y + component.getTop()

        val deltaX = absolutX - moveableComponent.dragOffset.first
        val deltaY = absolutY - moveableComponent.dragOffset.second

        moveableComponent.dragOffset = Pair(absolutX, absolutY)

        val newX = component.getLeft() + deltaX
        val newY = component.getTop() + deltaY

        component.setX(PixelConstraint(newX))
        component.setY(PixelConstraint(newY))
    }

    // Function to attach the onMouseDragHandler to HomeTopBarRounded
    fun makeHomeTopBarRoundedDraggable(HomeTopBarRounded: UIComponent) {
        HomeTopBarRounded.onMouseDrag(onMouseDragHandler)
    }
}
package ie.fernandarocha.granadegame

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas

class Player(private val image: Bitmap) {
    private var x: Int = 0
    private var y: Int = 0
    private val w: Int
    private val h: Int
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeigth = Resources.getSystem().displayMetrics.heightPixels

    init {
        w = image.width
        h = image.height

        x = screenWidth/2
        y = screenHeigth - 200
    }

    fun draw(canvas: Canvas){
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * Update properties for the game object
     * when the player touches the screen, position the player bitmap there
     */
    fun updateTouch(touchX: Int, touchY: Int){
        x = touchX - w/2
        y = touchY - h/2
    }
}
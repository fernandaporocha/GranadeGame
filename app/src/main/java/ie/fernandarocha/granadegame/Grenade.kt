package ie.fernandarocha.granadegame

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas

class Grenade (var image: Bitmap){
    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0
    private var xVelocity = 20
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeigth = Resources.getSystem().displayMetrics.heightPixels

    init {
        w = image.width
        h = image.height

        x = screenWidth/2
        y = screenHeigth/2
    }

    fun draw(canvas: Canvas){
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    fun update(){
        if(x>screenWidth-image.width || x < image.width){
            xVelocity *= -1
        }

        if(y>screenWidth-image.height || y < image.height){
            yVelocity *= -1
        }

        x += xVelocity
        y += yVelocity
    }
}
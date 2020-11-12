package ie.fernandarocha.granadegame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attributes: AttributeSet): SurfaceView (context, attributes), SurfaceHolder.Callback {
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        TODO("Not yet implemented")
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        TODO("Not yet implemented")
    }

    /**
     * Function to update the positions of player and game objects
     */
    fun update(){

    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
    }

}
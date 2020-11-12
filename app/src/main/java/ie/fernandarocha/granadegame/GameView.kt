package ie.fernandarocha.granadegame

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attributes: AttributeSet): SurfaceView (context, attributes), SurfaceHolder.Callback {
    private val thread: GameThread

    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry = true
        while(retry){
            try {
                thread.setRunning(false)
                thread.join()
            }catch (e:Exception){
                e.printStackTrace()
            }

            retry = false
        }
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
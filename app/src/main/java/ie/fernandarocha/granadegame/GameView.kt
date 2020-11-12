package ie.fernandarocha.granadegame

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attributes: AttributeSet): SurfaceView (context, attributes), SurfaceHolder.Callback {
    private val thread: GameThread
    private var grenade: Grenade? = null

    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

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
        grenade = Grenade(BitmapFactory.decodeResource(resources, R.drawable.grenade))
        thread.setRunning(true)
        thread.start()
    }

    /**
     * Function to update the positions of player and game objects
     */
    fun update(){
        grenade!!.update()
    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        grenade!!.draw(canvas)
    }

}
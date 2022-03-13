package infotoast

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class InfoToast(context: Context) {
    private var inputContext: Context = context

    fun error(errorText: String = "Unexpected error") {
        val errorToastObj = Toast.makeText(inputContext, "⚠ $errorText ⚠", Toast.LENGTH_SHORT)
        errorToastObj.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)

        errorToastObj.show()
    }

    fun info(infoText: String = "Something happen") {
        val infoToastObj = Toast.makeText(inputContext, infoText, Toast.LENGTH_SHORT)
        infoToastObj.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)

        infoToastObj.show()
    }
}
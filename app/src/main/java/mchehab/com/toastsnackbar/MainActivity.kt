package mchehab.com.toastsnackbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val linearLayout by lazy {
        findViewById<LinearLayout>(R.id.linearLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonShortToast).setOnClickListener {
            showShortToast("This is a short toast")
        }

        findViewById<Button>(R.id.buttonLongToast).setOnClickListener {
            showLongToast("This is a long toast")
        }

        findViewById<Button>(R.id.buttonCustomToast).setOnClickListener {
            showCustomToast("This is a custom toast")
        }

        findViewById<Button>(R.id.buttonShortSnackbar).setOnClickListener {
            showShortSnackbar("This is a short snackbar")
        }

        findViewById<Button>(R.id.buttonLongSnackbar).setOnClickListener {
            showLongSnackbar("This is a long snackbar")
        }

        findViewById<Button>(R.id.buttonIndefinite).setOnClickListener {
            showIndefiniteSnackbar("This is an indefinite snackbar")
        }
    }

    private fun showShortToast(text: String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
    }

    private fun showLongToast(text: String){
        Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
    }

    private fun showCustomToast(text: String){
        val view = layoutInflater.inflate(R.layout.custom_toast, null)
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = text

        val toast = Toast(this@MainActivity)
        toast.duration = Toast.LENGTH_LONG
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.view = view
        toast.show()
    }

    private fun showShortSnackbar(text: String){
        Snackbar.make(linearLayout, text, Snackbar.LENGTH_SHORT).show()
    }

    private fun showLongSnackbar(text: String){
        Snackbar.make(linearLayout, text, Snackbar.LENGTH_LONG).show()
    }

    private fun showIndefiniteSnackbar(text: String){
        val snackbar = Snackbar.make(linearLayout, text, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Dismiss", {snackbar.dismiss()})
        snackbar.show()
    }
}
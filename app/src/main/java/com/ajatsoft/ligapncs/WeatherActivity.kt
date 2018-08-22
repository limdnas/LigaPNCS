package com.ajatsoft.ligapncs

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import org.jsoup.Jsoup

class WeatherActivity : Activity() {
    internal var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        webView = findViewById(R.id.webview_weather) as WebView
        val test = 1
        val jsoupTask = JsoupTask()
        jsoupTask.execute("http://www.futbolfantasy.com/laliga/puntos")

    }

    private inner class JsoupTask : AsyncTask<String, Int, String>() {

        override fun doInBackground(vararg params: String): String {
            val url = params[0]
            var result = ""

            try {
                val doc = Jsoup.connect(url).get()
                /* https://jsoup.org/apidocs/org/jsoup/select/Selector.html */
                val elements1 = doc.select("main_header")
                elements1.remove()
                val elements2 = doc.select("main_header")
                elements2.remove()
                val elements3 = doc.select("link")
                elements3.remove()
               // val elements4 = doc.select("img")
                //elements4.remove()
                result = doc.toString()

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return result
        }

        override fun onPostExecute(result: String) {
            webView!!.loadDataWithBaseURL(null, result, "text/html", "utf-8", null)
            //webView!!.settings.textSize = WebSettings.TextSize.LARGEST
            //webView!!.settings.blockNetworkImage = true
            webView!!.webViewClient = WebViewClient()
            super.onPostExecute(result)
        }
    }
}

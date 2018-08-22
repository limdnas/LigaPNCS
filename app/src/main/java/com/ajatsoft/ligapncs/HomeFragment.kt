package com.ajatsoft.ligapncs


import android.app.Fragment
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        val  mWebView = view.findViewById<WebView>(R.id.webviewfh)
        mWebView.loadUrl("http://www.ligacnpcs.ga")

        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)

// Force links and redirects to open in the WebView instead of in a browser
        val webViewClient: WebViewClient = object: WebViewClient() {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {

                super.onPageFinished(view, url)

                mWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('d-none d-lg-block')[0].style.display='none'; " +
                        "var head = document.getElementsByClassName('navbar navbar-expand-lg navbar-light bg-light sticky-top ng-scope')[0].style.display='none'; " +



                        "})()"
                )
            }
        }
        mWebView.webViewClient = webViewClient






        return view

    }




}

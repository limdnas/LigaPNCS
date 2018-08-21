package com.ajatsoft.ligapncs.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.ajatsoft.ligapncs.R


/**
 * A simple [Fragment] subclass.
 */
class ReglamentoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_reglamento, container, false)

        val  mWebView = view.findViewById(R.id.webviewfr) as WebView
        mWebView.loadUrl("http://www.ligacnpcs.ga/views/rules.html")

        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)

// Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(WebViewClient())

        return view

    }
}
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
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        val  mWebView = view.findViewById(R.id.webviewfh) as WebView
        mWebView.loadUrl("http://www.ligacnpcs.ga")

        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)

// Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(WebViewClient())

        return view

    }


}

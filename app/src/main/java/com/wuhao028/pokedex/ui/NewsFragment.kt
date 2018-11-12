package com.wuhao028.pokedex.ui

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.wuhao028.pokedex.Constants.Companion.NEWS_URL
import com.wuhao028.pokedex.R
import kotlinx.android.synthetic.main.fragment_news.*

/**
 *Created by WuHao028 on 12/11/18
 */


class NewsFragment : Fragment() {


    private var mTitle: String? = null
    private var webView: WebView? = null

    companion object {
        fun getInstance(title: String): NewsFragment {
            val fragment = NewsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        poke_news.settings.javaScriptEnabled = true
        poke_news.settings.domStorageEnabled = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            poke_news.settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW)
        }
        poke_news_progress_bar.getIndeterminateDrawable()
                .setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        updateProgress()
        poke_news.loadUrl(NEWS_URL)
        webView = poke_news

        webview_back.setOnClickListener{
            if(true.equals(poke_news?.canGoBack())){
                poke_news.goBack()
            }
        }
    }

    fun updateProgress() {
        poke_news.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }
    }

}

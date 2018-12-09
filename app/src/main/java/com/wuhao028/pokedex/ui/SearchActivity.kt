package com.wuhao028.pokedex.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.presenter.SearchPresenter
import com.wuhao028.pokedex.showToast
import kotlinx.android.synthetic.main.layout_search_result.*

/**
 *Created by WuHao028 on 9/12/18
 */


class SearchActivity: AppCompatActivity() {

    private val mPresenter by lazy { SearchPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.layout_search_result)
        search_cancel.setOnClickListener { onBackPressed() }
        //键盘的搜索按钮
        et_search_view.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    closeSoftKeyboard()
                    val keyWords = et_search_view.text.toString().trim()
                    if (keyWords.isNullOrEmpty()) {
                        showToast("请输入你感兴趣的关键词")
                    } else {
                        mPresenter.querySearchData(keyWords!!)
                    }
                }
                return false
            }

        })
//        search_result_recycler.visibility = View.GONE
    }

    // 返回事件
    override fun onBackPressed() {
        closeSoftKeyboard()
        super.onBackPressed()
    }

    fun closeSoftKeyboard() {
        closeKeyBord(et_search_view, applicationContext)
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }


}
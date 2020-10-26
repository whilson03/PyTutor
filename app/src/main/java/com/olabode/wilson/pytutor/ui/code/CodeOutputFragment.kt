package com.olabode.wilson.pytutor.ui.code


import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.views.Interpreter


/**
 *   Created by OLABODE WILSON on 10/23/20.
 */
class CodeOutputFragment(val code: String) : BottomSheetDialogFragment() {

    private lateinit var interpreter: Interpreter
    private val behavior: BottomSheetBehavior<*>? = null
    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.code_output_sheet, container, false)
        interpreter = root.findViewById<Interpreter>(R.id.interpreter)

        val close = root.findViewById<android.widget.Toolbar>(R.id.toolbar)
        close.setNavigationOnClickListener { dismiss() }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interpreter.setCode()
        interpreter.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                val func = "javascript:run(`${code.replace("\n", "\\n").replace("\t", "\\t")}`)"
                view?.loadUrl(func)
            }
        }
        interpreter.webChromeClient = object : WebChromeClient() {}
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                    bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { l ->
                val behaviour = BottomSheetBehavior.from(l)
                setupFullHeight(l)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

}
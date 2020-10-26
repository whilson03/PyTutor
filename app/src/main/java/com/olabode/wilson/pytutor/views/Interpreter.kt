package com.olabode.wilson.pytutor.views

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

/**
 *   Created by OLABODE WILSON on 10/22/20.
 */
class Interpreter @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    companion object {
        private const val ANDROID_ASSETS_PATH = "file:///android_asset/"
    }


    // Our exposed function to show highlighted syntax
    fun setCode() {
        settings.javaScriptEnabled = true
        loadDataWithBaseURL(
                ANDROID_ASSETS_PATH /* baseUrl */,
                setUpPage() /* html-data */,
                "text/html" /* mimeType */,
                "utf-8" /* encoding */,
                "" /* failUrl */
        )
    }

    private fun setUpPage(): String {
        return """
            
           <html> 

    <style type="text/css">
         #outer
        {
            width:100%;
            text-align: start;
        }
        .inner
        {
            display: inline-block;
        }
    </style>

        <head> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="www/jquery-3.5.1.min.js" type="text/javascript"></script> 
        <script src="www/skulpt.min.js" type="text/javascript"></script> 
        <script src="www/skulpt-stdlib.js" type="text/javascript"></script> 
        </head> 

    <body> 
        

        <script type="text/javascript"> 

        var StopExecution = false;
        // output functions are configurable.  This one just appends some text
        // to a pre element.
        function outf(text) { 
            var mypre = document.getElementById("output"); 
            mypre.innerHTML = mypre.innerHTML + text; 
        } 

        function builtinRead(x) {
            if (Sk.builtinFiles === undefined || Sk.builtinFiles["files"][x] === undefined)
                    throw "File not found: '" + x + "'";
            return Sk.builtinFiles["files"][x];
        }



        Sk.configure({
          output: outf,
          // yieldLimit: 100,
          // execLimit: 5000,
          killableWhile: true,
          killableFor: true,
          
          inputTakesPrompt: true,
          // you can customise the input function - this can return a promise - the default is just to use window.prompt
          inputfun: function (args) {
            return new Promise((resolve, reject) => {
              setTimeout(function() {
                resolve(window.prompt(args))
              }, 250)
            })
          },
          read: builtinRead,
          __future__: Sk.python3
        });


        function run(code) {
          StopExecution = false;
          const prog = code;
          const output = document.getElementById("output");
          const status = document.getElementById("status");
          output.innerHTML = "";
          status.innerHTML = "Running" ;

          Sk.misceval.asyncToPromise(() =>
            Sk.importMainWithBody("<stdin>", false, prog, true), {
              // handle a suspension of the executing code
              // "*" says handle all types of suspensions
              "*": () => {
                if (StopExecution) throw "Execution interrupted"
              }
            },
          ).catch(err => {
            outf("\n" + err.toString());
          }).finally(() => {
            status.innerHTML = "Stopped" ;
          })
        }

        

        function stopit() {
          StopExecution = true;
        }

        </script> 

        <div id="outer">
          <div class="inner"><label id="status"><small>Running</small></label></div>
          <div class="inner"><button onclick="stopit()" type="button">Stop</button></div>
         
        </div>
     <pre id="output" ></pre> 

    </body> 
        
        
</html> 
                    
            
            
        """
    }
}
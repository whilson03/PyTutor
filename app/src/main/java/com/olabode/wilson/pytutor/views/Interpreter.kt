package com.olabode.wilson.pytutor.views

import android.content.Context
import android.os.Build
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

    fun setCode() {
        var isAboveApi21 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        settings.javaScriptEnabled = true
        loadDataWithBaseURL(
                ANDROID_ASSETS_PATH /* baseUrl */,
                if (isAboveApi21) setUpPageAboveApi21() else setUpPageApi21() /* html-data */,
                "text/html" /* mimeType */,
                "utf-8" /* encoding */,
                "" /* failUrl */
        )
    }


    private fun setUpPageAboveApi21(): String {
        return """ 
            
<html> 

<head> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="www/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="www/skulpt.min.js" type="text/javascript"></script> 
<script src="www/skulpt-stdlib.js" type="text/javascript"></script>
</head> 
<body>

<div id="outer"> 
    <div class="inner"><label id="status"><small>Running</small></label></div>
    <div class="inner"><button onclick="stopit()" type="button">Stop</button></div>
</div>


<script type="text/javascript"> 

    var StopExecution = false;
    
    
    function outf(text) { 
        var mypre = document.getElementById("output"); 
        mypre.innerHTML = mypre.innerHTML + text; 
    } 
    
    function stopit() {
      status.innerHTML = "Stopped";
      StopExecution = true;
    }

    function builtinRead(x) {
      if (Sk.builtinFiles === undefined || Sk.builtinFiles.files[x] === undefined) {
        throw "File not found: '" + x + "'";
      }
      return Sk.builtinFiles.files[x];
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
        return new Promise(function(resolve, reject){
          setTimeout(function() {
            resolve(window.prompt(args));
          }, 250);
        });
      },
      read: builtinRead,
      __future__: Sk.python3
    });



function run(code){
     StopExecution = false;
     const status = document.getElementById("status");
     const output = document.getElementById("output");
     output.innerHTML = "";
     status.innerHTML = "Running";

      Sk.misceval.asyncToPromise(() =>
        Sk.importMainWithBody("<stdin>", false, code, true), {
          // handle a suspension of the executing code
          // "*" says handle all types of suspensions
          "*": () => {
            if (StopExecution) throw "Execution interrupted";
          }
        }
      ).catch(function(err) {
        outf("\n" + err.toString());
      }).then(function(){
         status.innerHTML = "Stopped";
      });
}
</script>
<div>
<pre id="output" ></pre>
</div>

</body>

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
</html> 
"""
    }


    // code for LOLLIPOP

    fun setUpPageApi21(): String {
        return """
            <html> 

<head> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="www/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="www/skulpt.es5.min.js" type="text/javascript"></script> 
<script src="www/skulpt-stdlib.js" type="text/javascript"></script>
</head> 
<body>

<div id="outer"> 
    <div class="inner"><label id="status"><small>Running</small></label></div>
    <div class="inner"><button onclick="stopit()" type="button">Stop</button></div>
</div>


<script type="text/javascript"> 

    var StopExecution = false;
    
    
    function outf(text) { 
        var mypre = document.getElementById("output"); 
        mypre.innerHTML = mypre.innerHTML + text; 
    } 
    
    function stopit() {
      status.innerHTML = "Stopped";
      StopExecution = true;
    }

    function builtinRead(x) {
      if (Sk.builtinFiles === undefined || Sk.builtinFiles.files[x] === undefined) {
        throw "File not found: '" + x + "'";
      }
      return Sk.builtinFiles.files[x];
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
        return new Promise(function(resolve, reject){
          setTimeout(function() {
            resolve(window.prompt(args));
          }, 250);
        });
      },
      read: builtinRead,
      __future__: Sk.python3
    });

function run(code){
     StopExecution = false;
     const status = document.getElementById("status");
     const output = document.getElementById("output");
     output.innerHTML = "";
     status.innerHTML = "Running";

Sk.misceval.asyncToPromise(function(){
    Sk.importMainWithBody("<stdin>", false, code, true), {
      // handle a suspension of the executing code
      // "*" says handle all types of suspensions
      "*": function(){
        if (StopExecution) throw "Execution interrupted";
      }
    }
  }).catch(function(err) {
    outf("\n" + err.toString());
  }).then(function(){
     status.innerHTML = "Stopped";
  });

}




</script>
<div>
<pre id="output" ></pre>
</div>

</body>

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
</html> 
        """
    }
}
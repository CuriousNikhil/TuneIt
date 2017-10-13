# TuneIt

[![](https://www.jitpack.io/v/CuriousNikhil/TuneIt.svg)](https://www.jitpack.io/#CuriousNikhil/TuneIt)

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script><br>
TuneIt is an android library that let's you to create awesome PCM (Pulse-Code Modulation 16 bit) tones in your app!
The setup is very easy just follow the following steps:

<h4>step1</h4>
Add the JitPack repository to your build file
<pre>
<code> 
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  </code>
</pre>
<h4>step2</h4>
 Add the following dependency in your <code>app/build.gradle</code> file
 <pre>
 <code>
 	dependencies {
	        compile 'com.github.CuriousNikhil:TuneIt:1.0.1'
	}
 </code>
 </pre>
Tadaa!! now you are set to make some noise ,yeah!!


<h4>step3</h4>
Use the following cod snippet to create your own tone
<pre>
<code>
                    TuneIt.getInitialised().create(frequency, duration, volume, new StopToneListener() {
                        @Override
                        public void onTrackStopped() {
			    //tack playing stopped !
                            Toast.makeText(MainActivity.this, "Track stopped!", Toast.LENGTH_SHORT).show();
                        }
                    });
</code>
</pre>

Now in <code>version 1.0.1</code> Added a new utility class <code>Frequency</code><br>
You can use three octave frequencies of sound <br>

<code>
1.LOW 
</code><br>
<code>
2.MID
</code><br>
<code>
3.HIGH
</code><br>

Just put Frequency class constants at frequency argument<br>
If you want MID level put MID and follwoed by underscore + tone frequency <br>
Ex:<br>
<code>Frequency.MID_C</code> or <code>Frequency.HIGH_C_SHARP</code> or <code>Frequency.LOW_A_SHARP</code><br>
You can access all the tones of octave from <code>Frequency class</code><br>
<br>
If you want to play specific note from the specific frequency octave, It's added in Frequency Class.<br>
And you can do it as follows:<br>
<pre>
	<code>
		
	/*
	You can just set frequency to 
	Frequency.MID_C and similarly MID_A, MID_B, MID_D, MID_F
	*/
		
		TuneIt.getInitialised().create(Frequency.MID_C, duration, volume, new StopToneListener() {
                        @Override
                        public void onTrackStopped() {
			    //tack playing stopped !
                           //...
			   //...
                        }
                    });
	
	</code>
</pre>


Initialise or assign 
<code>frequency</code> as <code>int</code><br>
<code>duration</code> as <code>int</code><br>
<code>volume</code> as <code>double (ex: 1.0f for max volume)</code><br><br>
Refer to sample <a href="https://github.com/CuriousNikhil/TuneIt/blob/master/app/src/main/java/xyz/mystikolabs/tuneittest/MainActivity.java">app</a><br><br><br>

Yes you are done! Make your own piyano/casio or flute whatever !!<br>
Any forks/suggestions are always welcome! Focusing on integrating this library with AI to generate music on android.

<pre>
MIT License

Copyright (c) 2017 Nikhil Chaudhari

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</pre>



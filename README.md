# TuneIt

[![](https://www.jitpack.io/v/CuriousNikhil/TuneIt.svg)](https://www.jitpack.io/#CuriousNikhil/TuneIt)

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
	        compile 'com.github.CuriousNikhil:TuneIt:1.0'
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
Initialise or assign 
<code>frequency</code> as <code>int</code><br>
<code>duration</code> as <code>int</code><br>
<code>volume</code> as <code>float (ex: 1.0f for max volume)</code>
Refer to sample <a href="https://github.com/CuriousNikhil/TuneIt/blob/master/app/src/main/java/xyz/mystikolabs/tuneittest/MainActivity.java">app</a><br>

Yes you are done! Make your own piyano/casio or flute whatever !!
Any forks/suggestions are always welcome! I am focusing on how to make this library integrated ove AI to generate music.



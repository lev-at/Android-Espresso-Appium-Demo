package org.schabi.newpipe.visual;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.applitools.eyes.android.common.EyesRunner;
import com.applitools.eyes.android.espresso.ClassicRunner;
import com.applitools.eyes.android.espresso.Eyes;
import com.applitools.eyes.android.espresso.fluent.Target;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.schabi.newpipe.MainActivity;

@RunWith(AndroidJUnit4.class)
public class FullPageTest {

    private Eyes eyes;
    private EyesRunner runner;

    @Before
    public void beforeTest() {

        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey("fcq4rttvnfdjwWt6v99c8cC6FomulWtHwxz3fn104kPf6o110UfgTest");

        ActivityScenario.launch(MainActivity.class);
    }

        @Test
    public void test() {
        try {
            eyes.open("AndroidX Test App ", "UFG test");
            eyes.check("Check Fullpage", Target.window().fully());
            eyes.closeAsync();
        } finally {
            eyes.abortIfNotClosed();
            runner.getAllTestResults();
        }
    }
}

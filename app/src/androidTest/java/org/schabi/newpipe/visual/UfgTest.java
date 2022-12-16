package org.schabi.newpipe.visual;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.applitools.androidx.app.activity.TextFieldsActivity;
import com.applitools.eyes.android.common.AndroidDeviceInfo;
import com.applitools.eyes.android.common.AndroidDeviceName;
import com.applitools.eyes.android.common.DeviceAndroidVersion;
import com.applitools.eyes.android.common.ScreenOrientation;
import com.applitools.eyes.android.common.logger.Logger;
import com.applitools.eyes.android.common.logger.StdoutLogHandler;
import com.applitools.eyes.android.components.androidx.AndroidXComponentsProvider;
import com.applitools.eyes.android.espresso.Eyes;
import com.applitools.eyes.android.espresso.fluent.Target;
import com.applitools.eyes.android.espresso.visualgrid.RunnerOptions;
import com.applitools.eyes.android.espresso.visualgrid.VisualGridRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class UfgTest {

    @Before
    public void beforeTest() {
        ActivityScenario.launch(TextFieldsActivity.class);

    }

    @Test
    public void test() {
        final Logger logger = new Logger();
        logger.setLogHandler(new StdoutLogHandler(true));
        final VisualGridRunner runner = new VisualGridRunner(new
                RunnerOptions().apiKey("API KEY"));
        final Eyes eyes = new Eyes(runner);
        eyes.setComponentsProvider(new AndroidXComponentsProvider());
        eyes.setConfiguration(eyes.getConfiguration()
                .addMobileDevice(new AndroidDeviceInfo(AndroidDeviceName.Pixel_4))
                .addMobileDevice(new

                        AndroidDeviceInfo(AndroidDeviceName.Pixel_4_XL,
                        ScreenOrientation.Landscape))
                .addMobileDevice(new

                        AndroidDeviceInfo(AndroidDeviceName.Pixel_3_XL, ScreenOrientation.Landscape,
                        DeviceAndroidVersion.LATEST)));
        eyes.setLogHandler(logger.getLogHandler());
        try {
            eyes.open("AndroidX Test App ", "UFG test");
            eyes.check("Check Fullpage", Target.window());
            eyes.closeAsync();
        } finally {
            eyes.abortIfNotClosed();
            runner.getAllTestResults();
        }
    }
}

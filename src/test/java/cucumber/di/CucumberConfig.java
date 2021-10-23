package cucumber.di;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static cucumber.utilities.Location.VIDEO_PATH;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

@Configuration
public class CucumberConfig {
    @Autowired
    @Lazy
    ChromeDriver driver;

    @Bean(destroyMethod = "quit")
    @Scope(value = SCOPE_CUCUMBER_GLUE)
    @ConditionalOnMissingBean
    public WebDriver getChromeDriver() {
        return WebDriverManager.chromedriver().create();
    }

    @Bean(initMethod = "createSession", destroyMethod = "close")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Scope(value = SCOPE_CUCUMBER_GLUE)
    public DevTools getDevTools() {
        return driver.getDevTools();
    }

    @Bean(destroyMethod = "quit")
    @Scope(value = SCOPE_CUCUMBER_GLUE)
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getFirefoxDriver() {
        return WebDriverManager.firefoxdriver().create();
    }

    /**
     * initialize the screen recorder:
     * default graphics configuration
     * full screen recording
     * record in AVI format
     * 15 frames per second
     * black mouse pointer
     * no audio
     * save capture to predefined location
     *
     * @return screen recorder
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    @Scope(value = SCOPE_CUCUMBER_GLUE)
    public ScreenRecorder screenRecorder() throws IOException, AWTException {
        // set the graphics configuration
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        return new ScreenRecorder(gc,
                gc.getBounds(),
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null,
                new File(VIDEO_PATH));
    }
}

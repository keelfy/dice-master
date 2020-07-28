package keelfy.dice_master.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Internationalization configuration.
 *
 * @author keelfy
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer {

    /** Name of cookie that stores selected language */
    private static final String COOKIE_LANGUAGE_NAME = "language";

    /** Default locale for newbie */
    private static final Locale DEFAULT_LOCALE = Locale.US;

    /** Path to .properties files with localization */
    private static final String LANGUAGE_FILE_PATH = "lang/messages";

    /** Encoding of language files */
    private static final String LANGUAGE_FILE_ENCODING = StandardCharsets.UTF_8.displayName();

    /** site.site/greeting?INTERCEPTOR_PARAM_NAME=en */
    private static final String INTERCEPTOR_PARAM_NAME = "language";

    /**
     * @return Configurated {@link CookieLocaleResolver} with name of cookie and default locale.
     */
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setDefaultLocale(DEFAULT_LOCALE);
        clr.setCookieName(COOKIE_LANGUAGE_NAME);
        return clr;
    }

    /**
     * @return Configurated {@link ReloadableResourceBundleMessageSource} with path to lang files and their encoding.
     */
    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename("classpath:" + LANGUAGE_FILE_PATH);
        messageResource.setDefaultEncoding(LANGUAGE_FILE_ENCODING);
        return messageResource;
    }

    /**
     * an interceptor bean that will switch to a new locale based on the value of the language parameter appended to a request:
     *
     * @param registry
     * @language should be the name of the request param i.e  localhost:8010/api/get-greeting?language=en
     * <p>
     * Note: All requests to the backend needing Internationalization should have the "language" request param
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(INTERCEPTOR_PARAM_NAME);
        registry.addInterceptor(localeChangeInterceptor);
    }
}
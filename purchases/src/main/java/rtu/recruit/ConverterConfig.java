package rtu.recruit;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import rtu.recruit.enums.converters.CategoryStringConverter;
import rtu.recruit.enums.converters.PaymentTypeStringConverter;

@Configuration
public class ConverterConfig extends WebMvcConfigurationSupport {
    @Override
    public FormattingConversionService mvcConversionService() {
        FormattingConversionService f = super.mvcConversionService();
        f.addConverter(new CategoryStringConverter());
        f.addConverter(new PaymentTypeStringConverter());
        return f;
    }
}

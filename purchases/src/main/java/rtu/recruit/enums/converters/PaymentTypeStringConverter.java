package rtu.recruit.enums.converters;

import org.springframework.core.convert.converter.Converter;
import rtu.recruit.enums.PaymentType;


public class PaymentTypeStringConverter implements Converter<String, PaymentType> {

    @Override
    public PaymentType convert(String source) {
        try {
            return PaymentType.valueOf(source.toUpperCase());
        } catch (Exception e) {
            return PaymentType.BILLS;
        }
    }
}

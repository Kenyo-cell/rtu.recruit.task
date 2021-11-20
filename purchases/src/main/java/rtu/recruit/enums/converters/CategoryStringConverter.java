package rtu.recruit.enums.converters;

import org.springframework.core.convert.converter.Converter;
import rtu.recruit.enums.Category;

public class CategoryStringConverter implements Converter<String, Category> {

    @Override
    public Category convert(String source) {
        try {
            return Category.valueOf(source.toUpperCase());
        } catch (Exception e) {
            return Category.OTHER;
        }
    }
}

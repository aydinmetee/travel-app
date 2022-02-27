package tr.com.metea.travelapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * @author Mete Aydin
 * @since 28.10.2021
 */
@Service
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;

    public String get(String code) {
        return messageSource.getMessage(code, null,
                new Locale("tr"));

    }
}

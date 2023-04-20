package gn.boulet.simplewebservice.utils;

import java.util.function.Predicate;

public class PhoneNumberValider implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.startsWith("+224") && s.substring(4).length() == 9;
    }

    public boolean isTextValid(String text) {
        return (!text.isEmpty() && text.length() > 5);
    }
}

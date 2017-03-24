package ru.comita.esshop.utils;

import com.codeborne.selenide.logevents.EventsCollector;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.logevents.SimpleReport;
import com.google.common.base.Joiner;

import java.util.Iterator;
import java.util.OptionalInt;
import java.util.logging.Logger;

/**
 * Overrided class of Selenide SimpleReport;
 * Produced to work with UtilsClass and TextReportClass;
 */
public class CustomReport extends SimpleReport {

    private static final Logger log = Logger.getLogger(SimpleReport.class.getName());

    public CustomReport() {
    }

    public void start() {
        SelenideLogger.addListener("simpleReport", new EventsCollector());
    }

    public void finish(String title) {
        EventsCollector logEventListener = (EventsCollector) SelenideLogger.removeListener("simpleReport");
        OptionalInt maxLineLength = logEventListener.events().stream().map(LogEvent::getElement).map(String::length).mapToInt(Integer::intValue).max();
        int count = maxLineLength.orElse(0) >= 20 ? maxLineLength.getAsInt() + 1 : 20;
        StringBuilder sb = new StringBuilder();
        sb.append("Report for ").append(title).append('\n');
        String delimiter = '+' + Joiner.on('+').join(this.line(count), this.line(70), new Object[]{this.line(10), this.line(10)}) + "+\n";
        sb.append(delimiter);
        sb.append(String.format("|%-" + count + "s|%-70s|%-10s|%-10s|%n", new Object[]{"Element", "Subject", "Status", "ms."}));
        sb.append(delimiter);
        Iterator var7 = logEventListener.events().iterator();

        while (var7.hasNext()) {
            LogEvent e = (LogEvent) var7.next();
            sb.append(String.format("|%-" + count + "s|%-70s|%-10s|%-10s|%n", new Object[]{e.getElement(), e.getSubject(), e.getStatus(), Long.valueOf(e.getDuration())}));
        }

        sb.append(delimiter);
        log.info(sb.toString());

        /**
         * By utils class method calls:
         * UtilClass.attachTextMethod(String text)
         * that needed to be created with @Attachment annotation in Utils Class
         * like:
            @Attachment(value = "Text log")
            public static String attachText(String text){
                return text;
            }
         * this report will be attached to Allure-report;
         */

        TestUtils.attachText(sb.toString());
    }

    public void clean() {
        SelenideLogger.removeListener("simpleReport");
    }

    private String line(int count) {
        return Joiner.on("").join(java.util.Collections.nCopies(count, "-"));
    }

}

package com.stevenpg.catfacts;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@WebMvcTest
@ActiveProfiles("test")
public class AnnotationTestControllerTest {

    @Mock
    Appender appender;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory
                .getLogger(Logger.ROOT_LOGGER_NAME);
        when(appender.getName()).thenReturn("MOCK");
        when(appender.isStarted()).thenReturn(true);
        logger.addAppender(appender);
    }

    @org.junit.Test
    public void hello() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @org.junit.Test
    public void testCatFacts() throws Throwable {
        CatFactsAspect aspect = new CatFactsAspect();
        aspect.displayCatFact(Mockito.mock(ProceedingJoinPoint.class));
        Mockito.verify(appender, times(1)).doAppend(argThat(argument -> {
            return ((LoggingEvent) argument).getFormattedMessage().matches("[0-9]+\\..*");
        }));
    }

}
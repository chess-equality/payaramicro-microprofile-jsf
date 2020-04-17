package org.chessequality.payaramicro.microprofile.jsf.view;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;
import org.omnifaces.cdi.ViewScoped;

@Log4j2
@Named
@ViewScoped
public class PushBean implements Serializable {

    private static final long serialVersionUID = 7029271977172709834L;

    private static final AtomicLong counter = new AtomicLong();

    private boolean connected;

    @Inject
    @Push(channel = "counter")
    private PushContext push;

    public void toggle() {
        log.info("########## IN toggle...");
        connected = !connected;
    }

    public void increment() {
        log.info("########## IN increment...");
        long newValue = counter.incrementAndGet();
        log.info(">>>>>>>>>> newValue = {}", newValue);
        push.send(newValue);
    }

    public boolean isConnected() {
        log.info("########## IN isConnected...");
        return connected;
    }

    public Long getCount() {
        log.info("########## IN getCount...");
        log.info(">>>>>>>>>> counter = {}", counter.get());
        return counter.get();
    }
}

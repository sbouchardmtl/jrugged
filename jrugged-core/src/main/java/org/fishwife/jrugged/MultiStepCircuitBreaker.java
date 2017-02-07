package org.fishwife.jrugged;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * Cette classe est un décorateur de CircuitBreaker afin de l'utiliser dans un mode multi-step (pour mule)
 */
public class MultiStepCircuitBreaker {
	
	private CircuitBreaker decoratedCircuitBreaker;
	
	private MultiStepCircuitBreaker() {}
	
	public MultiStepCircuitBreaker (CircuitBreaker decoratedCircuitBreaker) {
		this.decoratedCircuitBreaker = decoratedCircuitBreaker;
	}
	
	public int hashCode() {
		return decoratedCircuitBreaker.hashCode();
	}

	public Throwable getTripException() {
		return decoratedCircuitBreaker.getTripException();
	}

	public String getTripExceptionAsString() {
		return decoratedCircuitBreaker.getTripExceptionAsString();
	}

	public boolean equals(Object obj) {
		return decoratedCircuitBreaker.equals(obj);
	}

	public <V> V invoke(Callable<V> c) throws Exception {
		return decoratedCircuitBreaker.invoke(c);
	}

	public String toString() {
		return decoratedCircuitBreaker.toString();
	}

	public void invoke(Runnable r) throws Exception {
		decoratedCircuitBreaker.invoke(r);
	}

	public <V> V invoke(Runnable r, V result) throws Exception {
		return decoratedCircuitBreaker.invoke(r, result);
	}

	public void setByPassState(boolean b) {
		decoratedCircuitBreaker.setByPassState(b);
	}

	public boolean getByPassState() {
		return decoratedCircuitBreaker.getByPassState();
	}

	public void trip() {
		decoratedCircuitBreaker.trip();
	}

	public void tripHard() {
		decoratedCircuitBreaker.tripHard();
	}

	public long getLastTripTime() {
		return decoratedCircuitBreaker.getLastTripTime();
	}

	public long getTripCount() {
		return decoratedCircuitBreaker.getTripCount();
	}

	public void reset() {
		decoratedCircuitBreaker.reset();
	}

	public Status getStatus() {
		return decoratedCircuitBreaker.getStatus();
	}

	public ServiceStatus getServiceStatus() {
		return decoratedCircuitBreaker.getServiceStatus();
	}

	public long getResetMillis() {
		return decoratedCircuitBreaker.getResetMillis();
	}

	public void setResetMillis(long l) {
		decoratedCircuitBreaker.setResetMillis(l);
	}

	public String getHealthCheck() {
		return decoratedCircuitBreaker.getHealthCheck();
	}

	public void setLimit(int limit) {
		decoratedCircuitBreaker.setLimit(limit);
	}

	public void setIgnore(Collection<Class<? extends Throwable>> ignore) {
		decoratedCircuitBreaker.setIgnore(ignore);
	}

	public void setWindowMillis(long windowMillis) {
		decoratedCircuitBreaker.setWindowMillis(windowMillis);
	}

	public void setFailureInterpreter(FailureInterpreter failureInterpreter) {
		decoratedCircuitBreaker.setFailureInterpreter(failureInterpreter);
	}

	public FailureInterpreter getFailureInterpreter() {
		return decoratedCircuitBreaker.getFailureInterpreter();
	}

	public void setExceptionMapper(CircuitBreakerExceptionMapper<? extends Exception> mapper) {
		decoratedCircuitBreaker.setExceptionMapper(mapper);
	}

	public void addListener(CircuitBreakerNotificationCallback listener) {
		decoratedCircuitBreaker.addListener(listener);
	}

	public void setListeners(ArrayList<CircuitBreakerNotificationCallback> listeners) {
		decoratedCircuitBreaker.setListeners(listeners);
	}

	public CircuitBreakerExceptionMapper<? extends Exception> getExceptionMapper() {
		return decoratedCircuitBreaker.getExceptionMapper();
	}
	
	public boolean allowRequest() {
		return decoratedCircuitBreaker.allowRequest();
	}

	public void close() {
		decoratedCircuitBreaker.close();
	}
	
	public void handleFailure(Throwable cause) throws Exception {
		decoratedCircuitBreaker.handleFailure(cause);
	}
	
	public boolean isOpen() {
		if (!decoratedCircuitBreaker.byPass) {
            if (!decoratedCircuitBreaker.allowRequest()) {
                return true;
            }
            
            return false;
        }
        else {
           return false;
        }
	}
}

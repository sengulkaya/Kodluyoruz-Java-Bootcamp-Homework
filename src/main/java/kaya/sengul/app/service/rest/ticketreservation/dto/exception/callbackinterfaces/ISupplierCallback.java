package kaya.sengul.app.service.rest.ticketreservation.dto.exception.callbackinterfaces;

@FunctionalInterface
public interface ISupplierCallback<R> {
    R get() throws Exception;
}

package kaya.sengul.app.service.rest.ticketreservation.dto.exception.service;

public class PassengerServiceException extends RuntimeException {
    public PassengerServiceException()
    {
        this(null);
    }

    public PassengerServiceException(String message)
    {
        this(message, null);
    }

    public PassengerServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        Throwable cause = this.getCause();

        return String.format("{message : %s%s}", super.getMessage(), cause != null ? ", causeMessage : " + cause.getMessage() : "");
    }
}

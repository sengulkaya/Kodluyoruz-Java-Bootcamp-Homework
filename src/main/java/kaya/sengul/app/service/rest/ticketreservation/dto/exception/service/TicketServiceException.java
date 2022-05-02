package kaya.sengul.app.service.rest.ticketreservation.dto.exception.service;

public class TicketServiceException extends RuntimeException {
    public TicketServiceException()
    {
        this(null);
    }

    public TicketServiceException(String message)
    {
        this(message, null);
    }

    public TicketServiceException(String message, Throwable cause)
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

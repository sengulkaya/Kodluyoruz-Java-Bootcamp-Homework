package kaya.sengul.app.service.rest.ticketreservation.dto.exception.service;

public class TurkishAirlinesServiceException extends RuntimeException {
    public TurkishAirlinesServiceException()
    {
        this(null);
    }

    public TurkishAirlinesServiceException(String message)
    {
        this(message, null);
    }

    public TurkishAirlinesServiceException(String message, Throwable cause)
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

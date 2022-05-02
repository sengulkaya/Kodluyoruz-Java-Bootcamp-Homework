package kaya.sengul.app.service.rest.ticketreservation.dto.exception.service;

public class PegasusAirlinesServiceException extends RuntimeException {
    public PegasusAirlinesServiceException()
    {
        this(null);
    }

    public PegasusAirlinesServiceException(String message)
    {
        this(message, null);
    }

    public PegasusAirlinesServiceException(String message, Throwable cause)
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

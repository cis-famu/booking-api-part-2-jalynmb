package edu.famu.booking.Util;

public record ApiResponse(boolean success, String message, Object data, Object error) {}

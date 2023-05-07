package com.victorgallegos.exceptions;

public class ResponseCodeError extends AssertionError {

  public ResponseCodeError(String message, Throwable cause) {
    super(message, cause);
  }
}

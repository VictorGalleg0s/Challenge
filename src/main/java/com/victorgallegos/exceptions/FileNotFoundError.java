package com.victorgallegos.exceptions;

public class FileNotFoundError extends AssertionError {
  public FileNotFoundError(String message, Throwable cause) {
    super(message, cause);
  }
}

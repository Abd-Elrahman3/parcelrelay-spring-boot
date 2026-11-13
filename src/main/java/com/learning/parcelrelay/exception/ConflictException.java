package com.learning.parcelrelay.exception;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;


public class ConflictException extends RuntimeException {
    public ConflictException(String message) { super(message); }
}

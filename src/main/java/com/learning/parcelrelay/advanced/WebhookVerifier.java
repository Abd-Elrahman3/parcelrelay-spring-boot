package com.learning.parcelrelay.advanced;

import java.util.*;
import java.time.*;
import java.math.BigDecimal;
import com.learning.parcelrelay.exception.*;
import com.learning.parcelrelay.domain.*;

/** D4 BR-401. See the matching README rule; add injected collaborators as needed. */
public class WebhookVerifier {
    public boolean verify(byte[] body, long timestamp, String signature, byte[] secret, Instant now) {
        throw new UnsupportedOperationException("TODO: D4 BR-401 verify");
    }
}

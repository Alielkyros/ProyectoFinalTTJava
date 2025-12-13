package com.techlab.speedrun.controller.response;

import java.time.LocalDateTime;

public record ApiResponse(
    boolean success,
    String message,
    LocalDateTime timestamp
) {}

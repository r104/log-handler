package com.logging.loggerLibrary.model;

import com.logging.loggerLibrary.enums.Level;
import lombok.*;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {
    @NonNull
    private String content;
    @NonNull
    private Level level;
    @NonNull
    private String namespace;
    private DateTime timestamp;
}
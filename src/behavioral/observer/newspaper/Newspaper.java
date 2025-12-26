package behavioral.observer.newspaper;

import java.time.LocalDate;

public record Newspaper(int id, String name, LocalDate date, String content, int pageSize) {}

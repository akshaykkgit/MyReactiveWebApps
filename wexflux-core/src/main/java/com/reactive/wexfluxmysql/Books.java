package com.reactive.wexfluxmysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    Integer bookid;
    String title;
    String author;

}

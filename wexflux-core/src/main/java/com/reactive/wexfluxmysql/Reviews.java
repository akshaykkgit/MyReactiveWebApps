package com.reactive.wexfluxmysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {

    Integer bookId;
    Double rating;
    String Comments;



}

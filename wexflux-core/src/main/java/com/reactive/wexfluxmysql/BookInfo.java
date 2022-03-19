package com.reactive.wexfluxmysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo
{
    Books books;
    List<Reviews> reviewsList;


}

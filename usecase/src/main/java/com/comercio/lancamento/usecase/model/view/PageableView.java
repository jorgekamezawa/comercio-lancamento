package com.comercio.lancamento.usecase.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageableView<T> {
    private List<T> dataList;
    private Long totalElements;
    private int totalPages;
}

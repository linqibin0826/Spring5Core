package com.linqibin.Chapter2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lqb
 * @date 2023/2/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String name;
}

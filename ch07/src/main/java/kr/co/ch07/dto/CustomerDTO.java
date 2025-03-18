package kr.co.ch07.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class CustomerDTO {
    private String custId;
    private String name;
    private int age;
    private String hp;
    private String regDate;
}